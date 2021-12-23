class Solution {
    fun longestDupSubstring(s: String): String {
        // 滑动窗口在s范围内移动，判断是否有重复  N
        // 使用二分，短的满足重复子串，尝试长的  logN
        // 判断字符串重复，如果用set会计算每个字符串的hashcode，而jvm会遍历，这样会增加 s.len的时间，冲突

        // 自然溢出怎么都会hash碰撞，用双hash才过

        val n = s.length
        // 对字符串hash，可以在O1求出子串hash
        val prime1 = 1610612741
        val prime2 = 49999
        val hash1 = IntArray(n+1)
        val hash2 = IntArray(n+1)
        val primeArr1 = IntArray(n+1)
        val primeArr2 = IntArray(n+1)
        primeArr1[0]=1
        primeArr2[0]=1
        for (i in 0 until n) {
            primeArr1[i+1]=primeArr1[i]*prime1
            primeArr2[i+1]=primeArr2[i]*prime2
            hash1[i+1]=hash1[i]*prime1+(s[i]-'a')
            hash2[i+1]=hash2[i]*prime2+(s[i]-'a')
        }

        var ans = ""
        // 二分求子串
        var l = 0
        var r = n-1
        while (l<=r){
            val m = l+(r-l)/2
            var match = false // 判断m长度的子串是否为重复子串
            val dict = hashMapOf<Int,Int>() // 记录出现过的子串hash
            var i = 1 // s子串对应hash为hash[1~n]
            while (i+m-1<=n){
                // 计算该hash是否出现过
                val curHash1 = hash1[i+m-1]-hash1[i-1]*primeArr1[m]
                val curHash2 = hash2[i+m-1]-hash2[i-1]*primeArr2[m]
                if (dict[curHash1]==curHash2) {
                    match=true
                    if (m>ans.length){
                        ans = s.substring(i-1,i+m-1)
                    }
                }else {
                    dict[curHash1]=curHash2
                }
                i++
            }
            dict.clear()
            if (match){
                // 找更长的
                l = m+1
            }else {
                r=m-1
            }
        }
        return ans
    }
}