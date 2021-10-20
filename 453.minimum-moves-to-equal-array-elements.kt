/**
 *Given a non-empty integer array of size n, find the minimum number of moves required to make all ar
 *ray elements equal, where a move is incrementing n - 1 elements by 1.                                                                                                                               
 *Example:                                                                                                                                                                                            
 *Input:                                                                                             
 *[1,2,3]                                                                                                                                                                                             
 *Output:  3                                                                                                                                                                                                    
 *Explanation:                                                                                       
 *Only three moves are needed (remember each move increments two elements):                                                                                                                           
 *[1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]   
 * 给一个数组大小为n，每次移动可以让n-1个数字+1   问多少次操作后可以让数组所有数相同                                                                                                                                                 
*/

class Solution {
    fun minMoves(nums: IntArray): Int {
        // 假设最后所有数都相同的值x ，操作的次数count 数组最小值是min
        // 每次操作最小的值肯定会参与，且操作后原先最小值还会是最小值，最多和别人并列最小了。
        // x = min + count    ----------1

    	var n = nums.size
    	var min = Int.MAX_VALUE
    	var sum = 0
    	for(i in nums) {
    		if(i<min) min = i
    		sum += i
    	}
    	// 原数组的和是sum  n-1个数被加了count次，最后的数组和即为等式左边
    	// 最后所有数相同，即为等式右边
    	// sum + (n-1)*count = x*n   -----------------2
    	// 根据1式和2式，得解
        return sum - min*n
    }
}
// 21/10/20
import kotlin.math.min
class Solution {
	fun minMoves(nums: IntArray): Int {
		// 每次使n-1个元素+1,让所有元素相等，返回最小操作次数
		// 每操作一次，总和增加 n-1 ,每次都操作最小值，设最终数组所有元素都加到x了
		// x = min + cnt
		// x*n=sum+(n-1)*cnt
		// -> min * n +cnt * n = sum + n*cnt - cnt
		// cnt = sum - min * n
		var min = Int.MAX_VALUE
		var sum = 0
		for (i in nums){
			min = min(min,i)
			sum+=i
		}
		return sum- min*nums.size
	}
}

