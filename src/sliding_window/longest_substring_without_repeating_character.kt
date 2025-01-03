package sliding_window

fun main() {
    println(lengthOfLongestSubstring("pwwkew"))
}

fun lengthOfLongestSubstring(s: String): Int {

    if (s.isEmpty()) return 0

    val set = HashSet<Char>()
    var left = 0
    var count = 0
    for (right in s.indices) {
        while (s[right] in set) {
            set.remove(s[left])
            left++
        }
        set.add(s[right])
        count = maxOf(count, right - left + 1)
    }

    return count
}