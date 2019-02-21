package easy.string

import kotlin.math.abs

/**
 *@Author: taoye
 *@Description:
 *@Date: 16:54 2019/2/20
 */

//给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
//
//示例 1:
//
//输入: 123
//输出: 321
//示例 2:
//
//输入: -123
//输出: -321
//示例 3:
//
//输入: 120
//输出: 21
//注意:
//
//假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。

fun reverse(x: Int): Int {
    if (x==0) return 0
    if (x==Int.MIN_VALUE) return 0 //会溢出的，正数比负数少了一个。
    var num = abs(x) //这里的x如果是最小值的话，绝对值是自身。系统api没有溢出这种事儿。
    var res = 0
    /*
    循环将原数/10，直到为0.跳出循环
    原数模10 取出个位。
    结果值先乘10 空出个位，将模加进去。
    */

    while (num > 0) {
        if (res > Int.MAX_VALUE / 10 || (res == Int.MAX_VALUE / 10 && num % 10 > Int.MAX_VALUE % 10)) {
            return 0
        }
        res *= 10
        res += num % 10
        num /= 10
    }
    return if (num < 0) -res else res
}