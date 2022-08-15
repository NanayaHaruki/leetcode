class MyCircularDeque(k: Int) {
  val data = IntArray(k){-1} // value 为0-1000 ，-1表示无数据
  var frontIndex = 0;var lastIndex = 0 // 当前点
  private fun nextIndex(i:Int,direction:Int):Int{
    val j = i+direction
    if(j<0) return data.size-1
    if(j==data.size) return 0
    return j
  }
  fun insertFront(value: Int): Boolean {
    return if(data[frontIndex]==-1){
      data[frontIndex]=value
      true
    }else {
      val ni = nextIndex(frontIndex,-1)
      if(data[ni]==-1){
        data[ni]=value
        frontIndex=ni
        true
      }else false
    }
  }
  
  fun insertLast(value: Int): Boolean {
    val ni = nextIndex(lastIndex,1)
    return if(data[lastIndex]==-1){
      data[lastIndex]=value
      true
    }else {
      if(data[ni]==-1){
        data[ni]=value
        lastIndex=ni
        true
      }else false
    }
  }
  
  fun deleteFront(): Boolean {
    if(data[frontIndex]==-1) return false
    data[frontIndex]=-1
    val i =nextIndex(frontIndex,1)
    if(data[i]!=-1) frontIndex=i
    return true
  }
  
  fun deleteLast(): Boolean {
    if(data[lastIndex]==-1) return false
    data[lastIndex]=-1
    val i =nextIndex(lastIndex,-1)
    if(data[i]!=-1) lastIndex=i
    return true
  }
  
  fun getFront(): Int {
    return data[frontIndex]
  }
  
  fun getRear(): Int {
    return data[lastIndex]
  }
  
  fun isEmpty(): Boolean {
    return frontIndex==lastIndex && data[frontIndex]==-1
  }
  
  fun isFull(): Boolean {
    return  nextIndex(lastIndex,1)==frontIndex && data[frontIndex]!=-1 && data[lastIndex]!=-1
  }
}