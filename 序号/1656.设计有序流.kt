class OrderedStream(val n: Int) {
  val arr=Array<String?>(n+1){null}
  var ptr  = 1
  fun insert(idKey: Int, value: String): List<String> {
    arr[idKey]=value
    if(ptr!=idKey) return emptyList()
    val l = mutableListOf<String>()
    var p = idKey
    while (p<=n && arr[p]!=null){
      l.add(arr[p++]!!)
    }
    ptr=p
    return l
  }
}