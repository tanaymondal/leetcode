package strings

// https://leetcode.com/problems/reverse-string-ii/
fun main() {
    println(reverseStr("abcd", 2))
}


fun reverseStr(s: String, k: Int): String {
    return s.chunked(k).mapIndexed { index, s ->
        if (index % 2 == 0) {
            s.reversed()
        } else {
            s
        }
    }.joinToString(separator = "")
}