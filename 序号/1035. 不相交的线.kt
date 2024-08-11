class Solution {
    lateinit var mem : Array<IntArray>
    fun dfs(n1:IntArray,n2:IntArray,i:Int,j:Int):Int{
        if(i<0 || j<0) return 0
        if(mem[i][j]!=-1) return mem[i][j]
        var ans = 0
        if(n1[i]==n2[j]) {
            ans=dfs(n1,n2,i-1,j-1)+1
        }else{
            ans=max(dfs(n1,n2,i-1,j),dfs(n1,n2,i,j-1))
        }
        mem[i][j]=ans
        return ans
    }
    fun maxUncrossedLines(nums1: IntArray, nums2: IntArray): Int {
        val m = nums1.size;val n = nums2.size;
        mem=Array(m){IntArray(n){-1}}
        return dfs(nums1,nums2,m-1,n-1)
    }
}