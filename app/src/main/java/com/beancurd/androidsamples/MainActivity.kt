package com.beancurd.androidsamples

import android.content.pm.PackageManager
import android.media.AudioFormat
import android.media.AudioRecord
import android.media.MediaRecorder
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import java.io.File
import java.io.FileOutputStream

class MainActivity : AppCompatActivity() {

    private lateinit var mBtnRecord: Button
    private lateinit var mTvPath: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mBtnRecord = findViewById<Button>(R.id.btn_record)
        mTvPath = findViewById<TextView>(R.id.tv_path)
        mBtnRecord.text = "开始录音"
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
                    for (i in 0 until read) {
                        os.write((buffer[i].toInt() shr 8).toByte().toInt())
                        os.write((buffer[i].toInt() and 0xff.toShort().toInt()).toByte().toInt())
                    }
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

}