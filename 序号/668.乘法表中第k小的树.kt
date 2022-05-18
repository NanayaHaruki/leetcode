fun findKthNumber(m: Int, n: Int, k: Int): Int {
  // 在矩阵中找第k大的数，m为高，n为宽，最小值为1 最大值为mn；
  // 不断二分猜答案 x=（1+mn）/2，检查有y个数比x小
  // y==k x就是答案，y>k ,x还是大了，继续缩小二分查；y<k,x小了，继续二分
  // 问题转化为 比x小的数有多少。第5行的数字为 5 10 15 20 比x小的数有x/5个，当然最多不会超过4个。
  // 先确认x在第几行 x/n 之前的行，所有值都比x小，前x/n行比x小的数有x/n*n个，x/n之后所有行都有一部分比x小
  
  // 不断猜x
  var l = 1
  var r = m*n
  while (l<=r){
    val x = (l+r).shr(1)
    val cnt = count(m,n,x)
    if (cnt==k) r=x-1
    else if(cnt>k) r=x-1
    else l=x+1
  }
  return l
}

private fun count(m: Int, n: Int, x:Int):Int{
  // 找比x小的有多少个
  var cnt = x/n*n
  // 从x/n+1 开始，每一行只有x/m个小于x的数
  for (i in x/n+1 .. m){
    cnt+= x/i
  }
  return cnt
}