class Solution {
    fun rowAndMaximumOnes(mat: Array<IntArray>): IntArray {
        val ans = IntArray(2)
        mat.forEachIndexed{i,row->
            row.sum().let{
                if(it>ans[1]){
                    ans[1]=it
                    ans[0]=i
                }
            }
        }
        return ans
    }
}