class Solution {
    fun doesValidArrayExist(derived: IntArray): Boolean {
        // derived[i]=o[i] xor o[i+1]
        // derived[i+1]=o[i+1] xor o[i+2]
        // 可以看出derived中的所有值都是由 原数组中的元素参与异或运算2次构成
        // 异或2次必然为0
        return derived.reduce(Int::xor)==0
    }
}