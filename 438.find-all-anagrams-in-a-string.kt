/* 
在字符串s中找到p出现的角标
p的顺序无所谓
Input:                        
s: "cbaebabacd" p: "abc"      
    0     6                     
Output:                       
[0, 6]  
*/                      
class Solution {
    fun findAnagrams(s: String, p: String): List<Int> {
        val list = mutableListOf<Int>()
        if (s.isEmpty() || p.isEmpty()) return list
//        left和right表示s中的左右两个指针
//        count为s中匹配到p中元素的数量。匹配到一个，count递减，减到0了则完全匹配，left作为左边的指针即为所求的角标，加入返回结果list中
//        ASCII数组用来存储p中字符的出现次数。按照ASCII码表每个字符对应一个数字，比如小写A为65  a为97
        var left = 0
        var right = 0
        var count = p.length
        val ASCII = IntArray(256)
//        遍历p之后，比如p中出现A一次，那么ASCII[65]=1  如果没出现则为0
        for (c in p) {
            ASCII[c.toInt()]++
        }
//        从0开始，每次循环，右指针right都会递增 直到达到s的角标上限
        while (right < s.length) {
//            如果ASCII中有这个字符，则匹配数count递减
            if (ASCII[s[right].toInt()] >= 1) count--
//            当前字符在ASCII中递减，这样出现过得字符数量会-1，没出现过得会变成负值
            ASCII[s[right].toInt()]--
//            指针右移
            right++
//            匹配数到0，存入结果
            if (count == 0) list.add(left)

//            左右指针之间的距离等于p的长度
//            如果count到0了，上一行已经将结果存入结果。
//            如果没到0说明没匹配上，无论怎样，左指针都需要右移来继续匹配
//            当left为0，right-left第一次等于p长度之前，下面代码不执行。之后 每次循环，left和right都会右移一格。
//            如果left处字符存在于p中，那么right在经过该处的时候，会把匹配值count-1，后面因为需要判断新的元素了，所以需要将匹配值恢复1点
            if (right - left == p.length) {
                if (ASCII[s[left].toInt()] >= 0) count++
                ASCII[s[left].toInt()]++
                left++
            }
        }
        return list
    }

  
}
