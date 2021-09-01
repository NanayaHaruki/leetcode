import kotlin.math.max
class Solution {
    fun compareVersion(version1: String, version2: String): Int {
        val v1 = version1.split(".")
        val v2 = version2.split(".")
        for (i in 0 until max(v1.size,v2.size)){
            val num1 = (v1.getOrNull(i)?:"0").toInt()
            val num2 :Int= (v2.getOrNull(i)?:"0").toInt()
            if (num1>num2) return 1
            else if(num1<num2)return -1
        }
        return 0
    }
}