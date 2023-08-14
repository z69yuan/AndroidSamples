package com.beancurd.kadvance

import kotlin.jvm.internal.MutablePropertyReference0Impl

/**
 *
 *  委托属性: 委托的是属性的get、set方法
 * @author beancurdv on 2023/8/11
 */

class  Sample02 {

    val de = FloatValueController(this)

    var floatValue : Float = 0.383838f
        set(value) {
            field = value
            println("curValue: $value")
        }

        get() {
            println("curValue: $field")
            return field
        }

    var number : Float by ::floatValue


    fun setNewValue(newV: Float) {
        de.set(newV)
    }

}


class FloatValueController(r: Sample02) : MutablePropertyReference0Impl(
    r, Sample02::class.java,
    "floatValue",
    "getFloatValue()F",
    0
) {
    override fun set(value: Any?) {
        (receiver as Sample02).floatValue = value as Float
    }

    override fun get(): Any {
        return (receiver as Sample02).floatValue
    }
}


class  Sample03 {

    var floatValue : Float = 0.383838f
        set(value) {
            field = value
            println("curValue: $value")
        }

        get() {
            println("curValue: $field")
            return field
        }

    var number : Float by ::floatValue


    /**
     *
     */
    var responseSuccess = ""

    var responseSuccessV2 by ::responseSuccess
}

fun main() {
    // 作用： 还是代理的本质; 对于Get的作用 ； 对于set的作用
    // 委托属性源码分析
    // by Lazy 源码实现
    Sample02().number = 0.1f
    Sample02().setNewValue(0.2f)
}

/**
 * 作用之一  兼容性问题
 */
class Response {
    /**
     *
     */
    var responseSuccess = ""

    var responseSuccessV2 by ::responseSuccess
}