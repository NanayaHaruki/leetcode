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
}
