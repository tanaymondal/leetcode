package two_pointer


// https://leetcode.com/problems/valid-palindrome/description/
fun main() {
    val s = "A man, a plan, a canal: Panama"
    println(validPalindrome(s))
}

fun validPalindrome(s: String): Boolean {

    var left = 0
    var right = s.length - 1
    while (left <= right) {
        if (!s[left].isValidAlphabetOrDigit()) {
            left++
            continue
        }

        if (!s[right].isValidAlphabetOrDigit()) {
            right--
            continue
        }

        if (s[left].lowercase() != s[right].lowercase()) {
            return false
        }
        left++
        right--
    }
    return true
}

fun Char.isValidAlphabetOrDigit(): Boolean {
    return (this in 'A'..'Z') || (this in 'a'..'z') || (this in '0'..'9')
}