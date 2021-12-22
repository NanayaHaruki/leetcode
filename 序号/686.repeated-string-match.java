// A重复n次后变成nA   B为nA的子串，求n
// 若不满足，返回n=-1
class Solution {
    public int repeatedStringMatch(String A, String B) {
        int repeat = 1;
        StringBuilder nA = new StringBuilder(A);
        while (nA.length() < B.length()) {
            nA.append(A);
            repeat++;
        }
//        先让A重复到长度足以包含B
//        如果indexOf能找到，那返回当前重复次数
        if(nA.indexOf(B)>=0) return repeat;
//        如果B是个回文，需要多加一次才能判断
        if(nA.append(A).indexOf(B) >= 0) return ++repeat;
//        找不到就返回-1
        return -1;
    }

    // kotlin 21-12-22
    fun repeatedStringMatch(a: String, b: String): Int {
        // b 可能用到a头尾的一部分 ，拼接后的a总长最多2a+b
        val sb = StringBuilder(a)
        var ans = 1
        val maxLen = a.length*2+b.length
        while (sb.length<=maxLen){
            if (sb.contains(b)) {
                return ans
            }else {
                ans++
                sb.append(a)
            }
        }
        return -1
    }
}
