package com.beancurd.androidsamples

/**
 *
 *
 * @author  on 2023/9/21
 */


val rex = """^(?!\\d+${'$'})[a-zA-Z0-9\u4e00-\u9fa5&]{3,}${'$'}"""

fun check(c:String) = c.matches(rex.toRegex())