class Solution {
  fun validateStackSequences(pushed: IntArray, popped: IntArray): Boolean {
    // 判断压栈和弹栈能否匹配
    // 弹栈指针不断右移，压栈指针指向栈顶，如果等于弹栈，压栈指针左移；如果不等，继续压栈直到出现弹栈信息。（找不到则不满足，弹栈走完了则满足）
    var pushIndex = -1;var popIndex = 0
    val len = popped.size
    while(popIndex<len){
      val popNum = popped[popIndex++]
      // 如果栈顶不是这个数，就压栈压到这个数
      if(pushIndex==-1 || pushed[pushIndex]!=popNum){
        do{
          pushIndex++
        } while(pushIndex<len && pushed[pushIndex]!=popNum)
        if(pushIndex==len) return false // 找不到这个数，直接返回
      }
      pushed[pushIndex]=-1 // 找到了，做弹栈
      do{
        pushIndex-- // 回退，找栈顶
      }while(pushIndex>=0 && pushed[pushIndex]<0)
      
    }
    return true
  }
}