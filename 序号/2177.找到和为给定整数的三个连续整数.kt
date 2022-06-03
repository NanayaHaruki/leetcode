fun sumOfThree(num: Long): LongArray {
  if(num%3!=0L) return longArrayOf()
  val x= num/3
  return longArrayOf(x-1,x,x+1)
}