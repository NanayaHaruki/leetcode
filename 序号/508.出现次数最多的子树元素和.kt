val dict = mutableMapOf<Int,Int>()
fun findFrequentTreeSum(root: TreeNode?): IntArray {
  if (root==null)return IntArray(0)
  sum(root)
  val ans = mutableListOf<Int>()
  var maxCnt = 0
  for((k,v)in dict){
    if (v>maxCnt) {
      ans.clear()
      ans.add(k)
      maxCnt=v
    }else if(v==maxCnt){
      ans.add(k)
    }
  }
  return ans.toIntArray()
}

fun sum(root:TreeNode?):Int{
  if(root==null) return 0
  var sum=root.`val`
  if(root.left!=null){
    val l = sum(root.left)
    sum+=l
  }
  if(root.right!=null){
    val r = sum(root.right)
    sum+=r
  }
  dict[sum]=(dict[sum]?:0)+1
  return sum
}