package strings

fun main() {

}


fun validIPAddress(queryIP: String): String {

    if (queryIP.isEmpty()) {
        return "Neither"
    }

    if (queryIP.contains(".") && !queryIP.contains(":")) {
        val array = queryIP.split(".")
        if (array.size != 4) {
            return "Neither"
        }

        for (data in array) {
            val n = data.toIntOrNull() ?: return "Neither"
            if (data.length == 1) {
                if (n !in 0..9) {
                    return "Neither"
                }
            } else if (data.length == 2) {
                if (n !in 10..99) {
                    return "Neither"
                }
            } else if (data.length == 3) {
                if (n !in 100..255) {
                    return "Neither"
                }
            } else {
                return "Neither"
            }
        }

        return "IPv4"

    } else if (queryIP.contains(":") && !queryIP.contains(".")) {

        val array = queryIP.split(":")
        if (array.size != 8) {
            return "Neither"
        }

        for (data in array) {
            if (data.length !in 1..4) {
                return "Neither"
            }

            val cArray = data.toCharArray()
            for (c in cArray) {
                if (c !in '0'..'9' && c !in 'a'..'f' && c !in 'A'..'F') {
                    return "Neither"
                }
            }
        }

        return "IPv6"

    } else {
        return "Neither"
    }
}