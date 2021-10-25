// 判断一个it是否为回文 比如121
// 能否不转成string进行判断？
class Solution {
    public boolean isPalindrome(int x) {
//        负数的肯定不是回文  不可能有int最后一位是'-'   10以内正数肯定是回文，就一位嘛
        if (x < 10) {
            if (x >= 0) return true;
            else return false;
        }
//        最后一位是0的肯定不行  int不可能以0开头
        if (x % 10 == 0) return false;
//        从x的后面一位一位的取数字累加成lastSub   比如12321的话，随着循环 lastSub会变成1  12  123
        int lastSub = 0;
        while (x > lastSub) {
//            每次循环，lastSub多一位   x少一位，当x小于lastSub的时候，说明过半了，已经可以判断是否为回文；跳出循环
            lastSub = lastSub * 10 + x % 10;
            x /= 10;
        }
        return x == lastSub || x == lastSub/10;
    }
}
