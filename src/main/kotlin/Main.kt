package main.kotlin

import java.time.zone.ZoneOffsetTransitionRule
import java.util.ArrayDeque

class Solution {
    fun isAdditiveNumber(num: String): Boolean {
        // 回溯 看前2个数怎么分  最少3个数，前2个数最多num/2位
        for (length in 2..num.length) {
            for (split in 1 until length) {
                if (check(num, length, split))
                    return true
            }
        }
        return false
    }

    /** @param length 前2个数长度
     *  @param split 第1个数长度
     * */
    fun check(num: String, length: Int, split: Int): Boolean {
        val n1Str = num.substring(0, split)
        val n2Str = num.substring(split, length)
        if (n1Str.length > 1) {
            for (element in n1Str) {
                if (element != '0') break
                else return false
            }
        }
        if (n2Str.length > 1) {
            for (element in n2Str) {
                if (element != '0') break
                else return false
            }
        }

        val n1 = n1Str.toLong()
        var n2 = n2Str.toLong()
        var n3 = (n1 + n2).toString()
        var _num = num.substring(length)
        while (n3.length <= _num.length) {
            val subN3 = _num.substring(0, n3.length)
            if (subN3 != n3)
                return false
            if (n3.length == _num.length)
                return true
            _num = _num.substring(n3.length)
            val n4 = (n2 + n3.toLong()).toString()
            n2 = n3.toLong()
            n3 = n4
        }
        return false
    }
}


fun main() {
    val s = Solution()
    println(s.isAdditiveNumber("198019823962"))
}

fun printBit(num: Int, radix: Int) {
    val sb = StringBuilder()
    for (i in 31 downTo 0) {
        val bit = if ((num and (1 shl i)) == 0) '0' else '1'
        sb.append(bit)
        if (sb.length == 8) {
            print("${sb.toString().toInt(2).toString(radix)}_")
            sb.clear()
        }
    }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}