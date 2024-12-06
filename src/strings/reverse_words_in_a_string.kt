package strings

import two_pointer.isValidAlphabetOrDigit

// https://leetcode.com/problems/reverse-words-in-a-string/description/
fun main() {
    // Input: s = "the sky is blue"
    // Output: "blue is sky the"

    val input = "a good   example"
    println(reverseWords(input))
    println(reverseWords2(input))

}

fun reverseWords(s: String): String {
    val list = s.trim().split(" ").reversed()
    val finalList = mutableListOf<String>()
    for (index in 0 until list.size) {
        if (list[index].trim().isNotEmpty()) {
            finalList.add(list[index].trim())
        }
    }
    return finalList.joinToString(" ")
}

fun reverseWords2(s: String): String {

    val array = s.toCharArray()

    val string = StringBuilder()
    val list = mutableListOf<String>()
    for (index in 0 until array.size) {
        if (array[index] == ' ') {
            if (string.isNotEmpty()) {
                list.add(string.toString())
            }
            string.clear()
        } else {
            string.append(array[index].toString())
        }
    }
    if (string.isNotEmpty()) {
        list.add(string.toString())
    }

    val stringToReturn = StringBuilder()
    var isFirst = true
    for (index in list.size - 1 downTo 0) {
        if (isFirst) {
            stringToReturn.append(list[index])
        } else {
            stringToReturn.append(" ").append(list[index])
        }
        isFirst = false
    }
    return stringToReturn.toString()
}

