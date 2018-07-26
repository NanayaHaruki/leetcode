// 判定两个字符串结构一样
// For example,
// Given "egg", "add", return true.
// Given "foo", "bar", return false.
// Given "paper", "title", return true.
class Solution {
    fun isIsomorphic(s: String, t: String): Boolean {
    	// 将字符串中的每一个char 转成ASCII表，字符对应0~127，初始化两个-1的数组。
    	// arr1和arr2 就相当于是一个ASCII表，比如第65个就对应A,66对应B 这样子。 而arr1[65]存的值则是'A'上一次出现在字符串s中的索引位置。
    	val arr1 = IntArray(128, {-1})
        val arr2 = IntArray(128,{-1})
        for(i in s.indices) {
        	// 如果没有变更，说明是第一次出现，那两个值都是初始化的-1.也是相等的 
        	// 若不相等，说明该字符在前面曾经出现过，而出现的位置不同，那么结构就不同了。
            // 比如AAA  AAB   当i是2的时候，arr1[65] = 1  arr2[66] = -1
            if(arr1[s[i].toInt()] != arr2[t[i].toInt()]) return false
            // 将最后一次出现在字符串中的索引存入arr中，以供后面循环进行比较
            arr1[s[i].toInt()] = i
            arr2[t[i].toInt()] = i
        }
        return true

    }
}
