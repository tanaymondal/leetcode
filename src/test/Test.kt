package test

import java.math.BigInteger

fun compute(a: Int, b: Int, add: (Int, Int) -> Unit) {
    return add(a, b)
}

fun main() {

    compute(2, 3) { a: Int, b: Int ->
        println(a + b)
    }


    //println(Height(6) square Width(6))

    //printIt<String>()

    //println(isItPalindrome(13321))

//    for (index in (0 until 15).reversed()) {
//        println(index)
//    }

//    val list = mutableListOf(1,2,3)
//    val set = HashSet<List<Int>>()
//    set.add(list)
//    set.add(list)
//    println(set)
//
//    println(fact(100))

    val map = mutableMapOf<Char, Int>()
    val map1 = mutableMapOf<Int, Char>()

    var start = 0
    for (i in 'a'..'z') {
        map[i] = start
        map1[start] = i
        start++
    }


    for (i in 1 until 26) {
        val random1 = (1..26).random()
        val random2 = (1..26).random()

        val value1 = map1[random1]
        val value2 = map1[random2]

        map[value1!!] = random1
        map[value2!!] = random2
    }
}

fun fact(number: Int): BigInteger {
    if (number == 1) {
        return 1.toBigInteger()
    }

    return number.toBigInteger() * fact(number - 1)
}


fun isItPalindrome(n: Int): Boolean {

    val data = n.toString().toCharArray()

    var startIndex = 0
    var endIndex = data.size - 1

    while (startIndex <= endIndex) {
        if (data[startIndex] != data[endIndex]) {
            return false
        }
        startIndex++
        endIndex--
    }
    return true
}

inline fun <reified T> printIt() {
    println(T::class)
}


infix fun Height.square(type: Width): Int {
    return this.height * type.width
}

@JvmInline
value class Height(val height: Int)

@JvmInline
value class Width(val width: Int)
