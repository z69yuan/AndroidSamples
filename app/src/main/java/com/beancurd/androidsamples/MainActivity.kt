package com.beancurd.androidsamples

import android.content.pm.PackageManager
import android.media.AudioFormat
import android.media.AudioManager
import android.media.AudioRecord
import android.media.AudioTrack
import android.media.MediaRecorder
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
import java.io.File
import java.io.FileInputStream
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.IOException

class MainActivity : AppCompatActivity() {

    private lateinit var mBtnRecord: Button
    private lateinit var mBtnPlay: Button
    private lateinit var mTvPath: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mBtnRecord = findViewById<Button>(R.id.btn_record)
        mTvPath = findViewById<TextView>(R.id.tv_path)
        mBtnRecord.text = "开始录音"
        mBtnPlay = findViewById<Button>(R.id.btn_play)
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
            outputFile?:return@setOnClickListener

            startPlaying()
        }
    }

    private fun startRecord() {
        if (checkPermission()) {
            startRecording()
        } else {
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.RECORD_AUDIO, android.Manifest.permission.WRITE_EXTERNAL_STORAGE), 101)
        }
    }

    private var audioRecord: AudioRecord? = null
    private lateinit var outputFile: File
    private var isRecording = false
    private val bufferSize: Int = AudioRecord.getMinBufferSize(16000, AudioFormat.CHANNEL_IN_MONO, AudioFormat.ENCODING_PCM_16BIT)
    private val buffer = ByteArray(bufferSize)

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
        mTvPath.text = outputFile.absolutePath
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
            16000,
            AudioFormat.CHANNEL_IN_MONO,
            AudioFormat.ENCODING_PCM_16BIT,
            bufferSize
        )

        audioRecord?.startRecording()
        isRecording = true
        mBtnRecord.text = "停止录音"
        Thread {
            try {
                val os = FileOutputStream(outputFile)
                while (isRecording) {
                    val read = audioRecord?.read(buffer, 0, bufferSize) ?: 0
                    os.write(buffer,0,read)
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

        val r = PcmToMp3.convertAudioFiles(outputFile.absolutePath,
            File(getExternalFilesDir("sgjk"), "recorded_audio.mp3").absolutePath)
        if(r.equals("ok")) {
            Toast.makeText(this,
                "保存成功",
                Toast.LENGTH_SHORT
            ).show()
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