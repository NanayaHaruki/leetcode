class Solution {
  fun findKthNumber(n: Int, _k: Int): Int {
      val limit = n.toString()
      fun getCnt(i:Int):Int{
          // 计算i树有多少节点
          // 分层计算 第1层1个  第2层10个 第3层100个  第j层 10^j个 ，这是个等比数列，只要知道层数就行。
          // 当n出现在x层时，总共 n-i^(x-1)+1
          val preCur= i.toString()
          val preLimit = limit.substring(0,preCur.length)
          val layer = limit.length-preCur.length+1
          if(i<preLimit.toInt()){ // 当前是123 ，限制是1245 ，则第1层123 ，第2层1230-1239都符合 总共11个
              return (10.0.pow(layer).toInt()-1)/9
          }else if(i == preLimit.toInt()){ // 如果前缀相同，当前123 limit 12345，第1层123 1230-1234  12300-12309
              return (10.0.pow(layer-1).toInt()-1)/9 + n-i*10.0.pow(layer-1).toInt()+1
          }else{ // 当前124,限制12388,只有自己可以
              return (10.0.pow(layer-1).toInt()-1)/9
          }
      }

      var node = 1
      var k = _k-1
      while(k>0){
          val sz = getCnt(node)
          if(sz>k){ // 就在这棵树下
              node*=10
              k--
          }else{ // sz==k时，因为根部重复计算了才刚好相等，实际上就是少了
              node++
              k-=sz
          }
      }
      return node
  }
}