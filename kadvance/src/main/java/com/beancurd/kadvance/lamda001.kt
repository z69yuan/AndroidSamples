package com.beancurd.kadvance

import java.util.function.Function


/**
 * lamda表达式0001
 *
 * @author beancurdv on 2023/8/22
 */


val method001:String.()->String  = {
    this + "aaaa"
}

val adder:Number.(Number) -> Number = {
        other -> this.toDouble() + other.toDouble() }



//val mutil:(()->Int,()->Int)->Int = {sum1, sum2-> sum1 * sum2 }
//val sum  = {a:Int , b:Int -> a + b }

val plus1 = {a :Int -> a + 1}
val mutl2 = {a :Int -> a * 2}

fun piple1 (vararg funcs:Function1<Int, Int>):(Int)->Int {
    return { it:Int->
        forEach(it, funcs.toList())
    }
}


val forEach = {initValue:Int, ops:List<Function1<Int,Int>> ->
    ops.fold(initValue) {a,b ->
        val r = b(a)
        println("r = $r")
        r
    }
}

val pipe = { ops:List<Function1<Int,Int>> ->
                { initValue:Int ->
                    ops.fold(initValue){ a, b->
                        b(a)
                    }
                }
            }


fun main() {
    println(method001("bbbb"))
//    println(method002("bbbb"))
    println(1.adder(2))

    println(piple1(plus1,mutl2)(5))
    println(pipe(listOf(plus1,mutl2))(5))

//    mutil(sum(1,2), sum(3,4))
}