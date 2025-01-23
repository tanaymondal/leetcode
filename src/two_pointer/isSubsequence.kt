package two_pointer

fun main() {

    val s = "abc"
    val t = "ahbgdc"

    println(isSubsequence(s, t))
}

fun isSubsequence(s: String, t: String): Boolean {

    var sStart = 0
    var tStart = 0

    while (sStart < s.length && tStart < t.length) {
        if (s[sStart] == t[tStart]) {
            sStart++
        }
        tStart++
    }

    return sStart == s.length
}