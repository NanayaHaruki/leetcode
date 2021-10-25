class Solution {
    fun peakIndexInMountainArray(arr: IntArray): Int {
        var left = 0
        var right = arr.lastIndex
        while(left<=right){
            val mid = left+(right-left)/2
            if(arr[mid]>arr[mid+1]){
                right = mid-1
            }else if(arr[mid]<arr[mid+1]){
                left = mid+1
            }else if(arr[mid]==arr[mid+1]){
                // 数组递增 该题用例不存在
            }
        }
        return left
    }
}