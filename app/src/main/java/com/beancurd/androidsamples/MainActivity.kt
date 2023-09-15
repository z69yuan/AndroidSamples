package com.beancurd.androidsamples

import android.content.Intent
import android.content.pm.PackageManager
import android.media.AudioFormat
import android.media.AudioManager
import android.media.AudioRecord
import android.media.AudioTrack
import android.media.MediaRecorder
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.beancurd.androidsamples.util.PcmToMp3
import com.beancurdv.nativelib.LameUtil
import com.beancurdv.nativelib.Mp3Decoder
import com.beancurdv.nativelib.PcmInfo
import com.beancurdv.nativelib.PcmToMp3Handler
import java.io.File
import java.io.FileInputStream
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.IOException
import java.util.Arrays


const val CONFIG_CHANNEL = AudioFormat.CHANNEL_IN_MONO
const val CONFIG_SAMPLE_RATE = 16000
const val CONFIG_BIT_DEEP = AudioFormat.ENCODING_PCM_16BIT



class MainActivity : AppCompatActivity() {

    private lateinit var mBtnRecord: Button
    private lateinit var mBtnPlay: Button
    private lateinit var mTvPath: TextView
    private lateinit var mLameIntro: TextView
    private lateinit var mPcmToMp3Handler: PcmToMp3Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mBtnRecord = findViewById<Button>(R.id.btn_record)
        mTvPath = findViewById<TextView>(R.id.tv_path)
        mBtnRecord.text = "开始录音"
        mBtnPlay = findViewById<Button>(R.id.btn_play)
        mLameIntro = findViewById<TextView>(R.id.tv_lame_intro)
        mLameIntro.text = "lame version : ${LameUtil.version()}"
        initListener()
    }

    private fun initListener() {
        mBtnRecord.setOnClickListener {
            if (!isRecording) {
                startRecord()
            } else {
                stopRecording()
            }
        }

        mBtnPlay.setOnClickListener {
            if(outputFile == null) {
                Toast.makeText(this,"请先录制声音",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            startPlaying()
        }
    }

    fun openFolder(folderPath: String) {
        val file = File(folderPath)
        if (!file.exists() || !file.isDirectory) {
            // 文件夹不存在 或者 也不是一个目录， 都直接返回
            return
        }
        val intent = Intent(Intent.ACTION_GET_CONTENT)
        val uri = Uri.parse(folderPath)
        intent.setDataAndType(uri, "*/*")
        startActivity(Intent.createChooser(intent, "Open folder"))
    }

    private fun startRecord() {
        if (checkPermission()) {
            startRecording()
        } else {
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.RECORD_AUDIO, android.Manifest.permission.WRITE_EXTERNAL_STORAGE), 101)
        }
    }

    private var audioRecord: AudioRecord? = null
    private var outputFile: File? = null
    private var isRecording = false
    private val bufferSize: Int = AudioRecord.getMinBufferSize(CONFIG_SAMPLE_RATE, CONFIG_CHANNEL, CONFIG_BIT_DEEP)
//    private val buffer = ByteArray(bufferSize)
    private val buffer = ShortArray(bufferSize)

    private fun startRecording() {
//        outputFile = File(Environment.getExternalStorageDirectory().absolutePath + "/recorded_audio.mp3")
        val dir = getExternalFilesDir("sgjk")
        if (dir == null) {
            Log.e("zfc","dir is null")
            return
        }
        if (!dir.exists()) {
            if (!dir.mkdirs()) {
                Log.e("zfc","dir create failed")
                return
            }
        }
        outputFile = File(getExternalFilesDir("sgjk"), "recorded_audio.pcm")
        mTvPath.text = outputFile!!.absolutePath
        if (ActivityCompat.checkSelfPermission(
                this,
                android.Manifest.permission.RECORD_AUDIO
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            return
        }
//        MediaRecorder.OutputFormat.
        audioRecord = AudioRecord(
            MediaRecorder.AudioSource.MIC,
            CONFIG_SAMPLE_RATE,
            CONFIG_CHANNEL,
            CONFIG_BIT_DEEP,
            bufferSize
        )
//        audioRecord?.setPositionNotificationPeriod()

        initMp3Encoder()


        audioRecord?.startRecording()
        isRecording = true
        mBtnRecord.text = "停止录音"
        Thread {
            try {
                val os = FileOutputStream(outputFile)
                while (isRecording) {
                    val read = audioRecord?.read(buffer, 0, bufferSize) ?: 0
//                    os.write(buffer,0,read)
                    // 将buffer的数据拷贝到newBuffer中
                    val newBuffer = buffer.copyOf(read)
                    mPcmToMp3Handler.sendMsg(newBuffer)
//                    for (i in 0 until read) {
//                        os.write((buffer[i].toInt() shr 8).toByte().toInt())
//                        os.write((buffer[i].toInt() and 0xff.toShort().toInt()).toByte().toInt())
//                    }
                }
                os.close()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }.start()
    }



    private fun stopRecording() {
        isRecording = false
        mBtnRecord.text = "开始录音"
        audioRecord?.stop()
        audioRecord?.release()
        audioRecord = null

        val r = PcmToMp3.convertAudioFiles(outputFile!!.absolutePath,
            File(getExternalFilesDir("sgjk"), "recorded_audio.mp3").absolutePath)
        if(r.equals("ok")) {
            Toast.makeText(this,
                "保存成功",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun initMp3Encoder() {
        val threadDecoder = Mp3Decoder()
        threadDecoder.start()
        mPcmToMp3Handler = PcmToMp3Handler(threadDecoder.looper).apply {
            initConfig(
                PcmInfo(
                   CONFIG_SAMPLE_RATE,
                   CONFIG_CHANNEL,
                    CONFIG_SAMPLE_RATE,
                    11,
                    2
                ),
                File(getExternalFilesDir("sgjk"), "recorded_audio_new.mp3")
            )
        }
    }

    override fun onStop() {
        super.onStop()
        if (isRecording) {
            stopRecording()
        }
    }

    private fun checkPermission(): Boolean {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val recordAudio = ContextCompat.checkSelfPermission(this,android.Manifest.permission.RECORD_AUDIO)
            val writeExtStorage = ContextCompat.checkSelfPermission(this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
            recordAudio == PackageManager.PERMISSION_GRANTED && writeExtStorage == PackageManager.PERMISSION_GRANTED
        } else {
            true
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 101) {
            startRecording()
        }
    }


    private fun startPlaying() {
        // 通过AudioTrack 模仿pcm文件
        val minBufferSize = AudioTrack.getMinBufferSize(44100, AudioFormat.CHANNEL_OUT_MONO, AudioFormat.ENCODING_PCM_16BIT)
        val audioTrack = AudioTrack(
            AudioManager.STREAM_MUSIC,
            16000,
            AudioFormat.CHANNEL_OUT_MONO,
            AudioFormat.ENCODING_PCM_16BIT,
            minBufferSize,
            AudioTrack.MODE_STREAM
        )

        val file = outputFile
        var fis: FileInputStream? = null
        try {
            fis = FileInputStream(file)
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        }
        fis?:return

        val tempBuffer = ByteArray(minBufferSize)

        try {
            audioTrack.play()
            while (fis?.available() ?: 0 > 0) {
                val readCount = fis?.read(tempBuffer) ?: 0
                if (readCount != AudioTrack.ERROR_INVALID_OPERATION && readCount != AudioTrack.ERROR_BAD_VALUE && readCount != 0 && readCount != -1) {
                    audioTrack.write(tempBuffer, 0, readCount)
                }
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}