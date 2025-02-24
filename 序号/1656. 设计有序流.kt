class OrderedStream(val n: Int) {
  var i = 1
  val link =Array<String?>(n+1){null}

  fun insert(idKey: Int, value: String): List<String> {
      link[idKey]=value
      if(link[i]==null) return emptyList()
      val ans = mutableListOf<String>()
      while(i<=n && link[i]!=null){
          ans.add(link[i++]!!)
      }
      return ans
  }

}

/**
* Your OrderedStream object will be instantiated and called as such:
* var obj = OrderedStream(n)
* var param_1 = obj.insert(idKey,value)
*/