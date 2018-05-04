// abc 走一步后变成 cab
// B能否走n步变成A
class Solution {
    public boolean rotateString(String A, String B) {
    	// 不管走几步，总体来说顺序是固定的，将A翻倍后 abcabc必然会包含走了N步的 比如cab
         return A.length() == B.length() && (A + A).contains(B);
    }
}
