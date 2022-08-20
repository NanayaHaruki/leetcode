class Solution {
  fun constructMaximumBinaryTree(nums: IntArray): TreeNode? {
    return dfs(nums,0,nums.size-1)
  }
  
  fun dfs(nums:IntArray,l:Int,r:Int):TreeNode?{
    if(l>r) return null
    var root=-1;var rootIndex = 0
    for(i in l..r){if(nums[i]>root) {
      root=nums[i]
      rootIndex=i
    }}
    val n = TreeNode(root)
    n.left = dfs(nums,l,rootIndex-1)
    n.right=dfs(nums,rootIndex+1,r)
    return n
  }
}