package test

fun main() {
    println(Height(6) square Width(6))

    printIt<String>()

    println(isItPalindrome(13321))
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