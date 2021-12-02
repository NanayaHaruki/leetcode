import java.util.*

class Solution {
    val ans = mutableListOf<MutableList<Int>>()
    /** 方法一  list.contains 为线性搜索，可以优化，其实就是空间换时间
    fun permute(nums: IntArray): List<List<Int>> {
        //全排列，定下左边的，尝试遍历右边的，尝试完之后回来
        backTrack(LinkedList(),nums)
        return ans
    }

    fun backTrack(list: LinkedList<Int>, nums: IntArray) {
        if (list.size == nums.size) {
            ans.add(LinkedList(list))
            return
        }
        for (i in nums) {
            if (list.contains(i)) continue
            list.addLast(i)
            backTrack(list, nums)
            list.removeLast()
        }
    }*/


    private lateinit var used:BooleanArray
    fun permute(nums: IntArray): List<List<Int>> {
        //全排列，定下左边的，尝试遍历右边的，尝试完之后回来
        used = BooleanArray(nums.size)
        backTrack(LinkedList(),nums)
        return ans
    }

    fun backTrack(list: LinkedList<Int>, nums: IntArray) {
        if (list.size == nums.size) {
            ans.add(LinkedList(list))
            return
        }
        for (i in nums.indices) {
            if (used[i]) continue
            list.addLast(nums[i])
            used[i]=true
            backTrack(list, nums)
            list.removeLast()
            used[i]=false
        }
    }

}