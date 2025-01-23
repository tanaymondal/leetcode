package array

fun groupAnagrams(strs: Array<String>): List<List<String>> {
    val res = mutableMapOf<String, MutableList<String>>()

    for (s in strs) {
        val sortedS = s.toCharArray().sorted().joinToString("")
        res.getOrPut(sortedS) { mutableListOf() }.add(s)
    }

    return res.values.toList()
}

fun groupAnagrams1(strs: Array<String>): List<List<String>> {
    val res = HashMap<List<Int>, MutableList<String>>()

    for (s in strs) {
        val count = MutableList(26) { 0 }
        for (c in s) {
            count[c - 'a']++
        }
        res.getOrPut(count) { mutableListOf() }.add(s)
    }

    return res.values.toList()
}

fun main() {
    val array = arrayOf("act","pots","tops","cat","stop","hat")
    println(groupAnagrams1(array))
}