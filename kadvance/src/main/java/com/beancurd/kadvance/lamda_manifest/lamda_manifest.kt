package com.beancurd.kadvance.lamda_manifest

import java.io.File
import java.io.Writer

/**
 *
 * lamda 生成清单文件
 * @author  on 2023/8/23
 *
 * manifest {
pkg("com.beancurdv.camera")
permission("android.permission")
application {
activity(".MainActivity") {
intent_filter {
action("android.intent.action.Main")
category("android.intent.category.LAUNCHER")
}
}
}
}
 */


fun main() {
    manifest {
        pkg("com.beancurdv.camera")
        permission("android.permission.A")
        permission("android.permission.B")
        permission("android.permission.C")
        permission("android.permission.D")
        application {
            mName = "BeancurdApp"
            activity(".MainActivity") {
                intent_filter {
                    action("android.intent.action.Main")
                    category("android.intent.category.LAUNCHER")
                }
            }
        }
    }

    val f = File("helloword.txt").writer().append("hello world! \n").append("你好")
    f.flush()
    f.close()
}


interface Scope {
    fun writeToXml(writer: Writer, level: Int)
}


fun Writer.writeLine(blankFormat: String, content: String) {
    append("""$blankFormat$content""").append("\n")
}


class ManifestScope : Scope {
    lateinit var mPackageName: String
    val mPermissionNames: HashSet<String> by lazy {
        HashSet<String>()
    }
    val  mApplicationScope: ApplicationScope by lazy {
        ApplicationScope()
    }

    val XML_SCHEME = """<?xml version="1.0" encoding="utf-8"?>"""
    /**
     * 这里的难点在于 level参数 动态变化；
     * lamda 如何藏属性变量？
     */
    override fun writeToXml(writer: Writer, level: Int) {
        val blank = "   ".repeat(level)
        writer.writeLine(blank, XML_SCHEME)
        val mergeLine = """$blank<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    package="$mPackageName">"""
        writer.writeLine(blank, mergeLine)
        // 写权限
        mPermissionNames.forEach { permissionName ->
            writer.writeLine("$blank    ", """<uses-permission android:name="$permissionName" />""")
        }
        mApplicationScope.writeToXml(writer, level + 1)
        writer.writeLine(blank,"""</manifest>""")
        writer.close()
    }
}

fun manifest(invoke:ManifestScope.()-> Unit) {
    ManifestScope().apply {
        invoke()
        writeToXml(File("android.xml").writer(),0)
    }
}

fun ManifestScope.pkg(packageName: String) {
    mPackageName = packageName
}
fun ManifestScope.permission(permissionName: String) {
    mPermissionNames.add(permissionName)
}


fun ManifestScope.application(compose: ApplicationScope.() -> Unit) {
    mApplicationScope.compose()
}

class ApplicationScope:Scope {
    var mName: String = ""
    val mActivities = HashSet<ActivityScope>()
    override fun writeToXml(writer: Writer, level: Int) {
        val blank = "   ".repeat(level)
        writer.writeLine(blank,"<application")
        writer.writeLine("$blank  ","""android:name="$mName"""")
        writer.writeLine(blank,">")
        mActivities.forEach { act ->
            act.writeToXml(writer, level + 1)
        }
        writer.writeLine(blank,"</application>")
    }
}

open class ComponentScope {
    lateinit var mIntentFilter: IntentFilterScope
}

data class ActivityScope(val name: String) : ComponentScope(),Scope {
    override fun writeToXml(writer: Writer, level: Int) {
        val blank = "   ".repeat(level)
        writer.writeLine(blank,"<activity")
        writer.writeLine("$blank  ","""android:name="$name"""")
        writer.writeLine(blank,">")
        mIntentFilter.writeToXml(writer, level + 1)
        writer.writeLine(blank,"</activity>")
    }
}

class IntentFilterScope:Scope {
    var mAction:String = ""
    var mCategory: String = ""

    fun action(actionName:String) {
        this.mAction = actionName
    }

    fun category(categoryName:String) {
        this.mCategory = categoryName
    }

    override fun writeToXml(writer: Writer, level: Int) {
        val blank = "   ".repeat(level)
        writer.writeLine(blank,"<intent-filter>")
        writer.writeLine("$blank  ","""<action android:name="$mAction" />""")
        writer.writeLine("$blank  ","""<category android:name="$mCategory" />""")
        writer.writeLine(blank,"</intent-filter>")
    }

}


fun ApplicationScope.activity(name: String, params: ActivityScope.() -> Unit) {
    mActivities.add(ActivityScope(name).apply {
        params()
    })
}

fun ActivityScope.intent_filter(intentFilter: IntentFilterScope.() -> Unit) {
    mIntentFilter = IntentFilterScope().apply { (intentFilter()) }
}


