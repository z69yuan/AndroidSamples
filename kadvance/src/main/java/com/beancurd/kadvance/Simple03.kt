package com.beancurd.kadvance

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * 自定义委托的两种形式与委托提供者
 *
 * @author beancurdv on 2023/8/14
 */


// 1. 自定义委托的两种形式

class Simple03 {
    var isCar = false
    var carTitle:String by Car()
    var elecTitle:String by Elec()
    var commonTitle : String by TitleAdapterDelegate{ isCar }
}


// 1. 普通委托类
class Car {
    private var title:String = ""

    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return title
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        this.title = value
        println("car title is $value")
    }
}

// 2. 实现 ReadWriteProperty接口
class Elec : ReadWriteProperty<Simple03,String> {

    private var title:String = ""

    override fun getValue(thisRef: Simple03, property: KProperty<*>): String {
        return title
    }

    override fun setValue(thisRef: Simple03, property: KProperty<*>, value: String) {
        this.title = value
        println("Elec title is $value")
    }
}


/**
 * 3. 委托提供者
 *  通过委托提供者 切换不同的委托类(前提是这些类 都实现了同一个委托接口 )
 */
class TitleAdapterDelegate(val isCar: () -> Boolean) {

    operator fun provideDelegate(thisRef: Simple03, property: KProperty<*>): ReadWriteProperty<Simple03, String> {
        return if (isCar()) {
            Elec()
        } else {
            Elec()
        }
    }
}

