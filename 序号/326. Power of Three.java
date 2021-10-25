import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。
 *
 * 示例 1:
 *
 * 输入: 27
 * 输出: true
 * 示例 2:
 *
 * 输入: 0
 * 输出: false
 * 示例 3:
 *
 * 输入: 9
 * 输出: true
 * 示例 4:
 *
 * 输入: 45
 * 输出: false
 * 进阶：
 * 你能不使用循环或者递归来完成本题吗？
 * @author:xzj
 * @date: 2018/9/11 8:58
 */
class Solution {
    public boolean isPowerOfThree(int n) {
//        方法一
//        double v = Math.log10(Integer.MAX_VALUE) / Math.log10(3);//找到int范围内最大的3的幂次方
//        double flo = Math.floor(v); //舍掉小数
//        double top = Math.pow(3.0, flo); //求出int范围内最大的3的幂次方
////        次大的值就是top/3了，所以满足3的幂次方的所有n均满足 模n为0
//        return n > 0 && top % n == 0;

//        方法二，三进制，用正则判断
        //        逢3进位，3的幂必然是 10  100 1000 10000这种
        return Integer.toString(n,3).matches("10*");
    }
}

class Solution() {
    fun isPowerOfThree(n: Int): Boolean {
        // 判断一个数是不是3的幂
        // 用3往上乘，乘出来有他就返回true，乘到大与它了就返回false
        val longN = n.toLong()
        if (longN<1) return false
        var i = 1L
        while (i<=Int.MAX_VALUE){
            when{
                i<longN->i*=3
                i>longN->return false
                i==longN-> return true
            }
        }
        return false
    }
}

