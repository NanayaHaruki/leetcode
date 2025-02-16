class Solution {
    fun replaceElements(arr: IntArray): IntArray {
        val n = arr.size
        var mx = -1
        for(i in n-1 downTo 0){
            var cur = arr[i]
            arr[i]=mx
            mx = max(mx,cur)
        }
        return arr
    }
}