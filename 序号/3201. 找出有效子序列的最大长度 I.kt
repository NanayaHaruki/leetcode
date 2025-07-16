class Solution {
  fun maximumLength(nums: IntArray): Int {
      // 子序列要么都是奇数 要么都是偶数 要么奇偶来回变
      // 定义f[i][0]为 前i个数 即[0,i)为止，最后个数是偶数的最长子序列的长度
      // 定义f[i][1]是最后是奇数的最长子序列长度
      // f[i][2] 为全偶的长度，f[i][3]为全奇的长度
 
      val f = IntArray(4)
      nums.forEachIndexed{i,x->
          if(x.and(1)==1){
              f[1]=f[0]+1
              f[3]+=1
          }else{
              f[0]=f[1]+1
              f[2]+=1
          }
      }
      return f.max()
  }
}