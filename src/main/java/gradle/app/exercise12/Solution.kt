package gradle.app.exercise12

object Solution {
    fun strStr(haystack: String?, needle: String?): Int {
        if (haystack == null) return -1
        if (needle == null) return -1
        if (needle.isEmpty()) return 0
        val lenTxt = haystack.length
        val lenPat = needle.length
        var idx = 0

        val map = mutableMapOf<Char, Int>()

        for (i in (lenPat - 1) downTo 0) {
            val v = map[needle[i]]
            if (v == null) {
                map[needle[i]] = (lenPat - i )
            }
        }

        println(map)

        while (idx < lenTxt && idx + lenPat <= lenTxt) {
            idx += if (haystack.substring(idx, idx + lenPat) == needle) {
                return idx
            } else {
                val next = idx + lenPat
                if (next >= lenTxt) return -1
                val c = haystack[next]
                map[c] ?: lenPat

            }
        }
        return -1
    }
}
