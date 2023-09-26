package com.beancurd.androidsamples.util

/**
 * Shell工具类
 *
 * @author zfc on 2023/9/22
 */

import android.util.Log
import java.io.BufferedReader
import java.io.InputStreamReader


fun executeShellCommand(command: String,cmdCode:Int = 0):String {
    try {
        // 获取root权限
        val process = Runtime.getRuntime().exec("sh")
        val os = process.outputStream

        // 执行命令
        os.write((command + "\n").toByteArray())
        os.write("exit\n".toByteArray())
        os.flush()

        // 获取命令执行结果
        val reader = BufferedReader(InputStreamReader(process.inputStream))
        var line: String?
        while (reader.readLine().also { line = it } != null) {
            Log.e("Dirk",line?:"")
            if(cmdCode == 3) {
                if(line?.contains("socket:[") == true) {
                     return line!!.split("socket:[")[1].run {
                        substring(0, length - 1)
                    }
                }
            }
            if(line?.contains("fd=") == true) {
                return line!!.split("fd=")[1].run {
                    substring(0, length - 2)
                }
            }
        }

        process.waitFor()
    } catch (e: Exception) {
        Log.e("zfc","shell ex ${e.message}")
        e.printStackTrace()
    }
    return ""
}
