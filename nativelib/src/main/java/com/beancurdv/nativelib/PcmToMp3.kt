package com.beancurdv.nativelib

import android.os.Handler
import android.os.HandlerThread
import android.os.Looper
import android.os.Message
import android.util.Log
import java.io.File
import java.io.FileOutputStream
import java.io.IOException

/**
 * PcmToMp3
 *
 * @author  on 2023/9/14
 */
data class PcmInfo(
    val inSampleRate:Int,
    val inChannel:Int,
    val outSampleRate:Int,
    val outBitrate:Int,
    val quality:Int
)
class PcmToMp3Handler(looper: Looper) : Handler(looper) {

    private lateinit var mTargetFile: FileOutputStream
    fun initConfig(pcmInfo: PcmInfo, target: File) {
        // 这个线程相关的吗
        pcmInfo.apply {
            LameUtil.init(
                inSampleRate,
                inChannel,
                outSampleRate,
                outBitrate,
                quality
            )
        }
        mTargetFile = FileOutputStream(target)
    }

    override fun handleMessage(msg: Message) {
        super.handleMessage(msg)

        when (msg.what) {
            CODE_ENCODE -> doEncode(msg.obj as ShortArray)
            CODE_FINISH -> doEncode(null)
            else -> {}
        }
    }

    fun sendMsg(buffer: ShortArray) {
        sendMessage(obtainMessage().apply {
            what = CODE_ENCODE
            obj = buffer
        })
    }

    /**
     * 解码数据的逻辑 (单声道解码)
     */
    private fun doEncode(buffer: ShortArray?) {
        Log.e("zfc","doEncode ..... ")
        val mp3Buffer = ByteArray(8192)
        var encodedSize = 0
        if (buffer == null) {
            encodedSize = LameUtil.flush(mp3Buffer)
        } else {
            encodedSize = LameUtil.encode(buffer, buffer, buffer.size, mp3Buffer)
        }
        if (encodedSize > 0) {
            try {
                Log.e("zfc","write 2 new file ..... ")
                mTargetFile.write(mp3Buffer, 0, encodedSize)
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }

        if(buffer == null) {
            mTargetFile.close()
        }
    }

    companion object {
        const val CODE_ENCODE = 0x01
        const val CODE_FINISH = 0x02
    }
}

class Mp3Decoder:HandlerThread("mp3decoder")