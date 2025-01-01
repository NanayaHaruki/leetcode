class Solution {
    fun convertDateToBinary(date: String): String {
        val sp = date.split('-')
        val sb = StringBuilder()

        return sb.append(sp[0].toInt().toString(2))
            .append('-')
            .append(sp[1].toInt().toString(2))
            .append('-')
            . append(sp[2].toInt().toString(2))
            .toString()
    }
}