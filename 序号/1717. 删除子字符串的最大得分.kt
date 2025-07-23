class Solution {
  fun maximumGain(s: String, x: Int, y: Int): Int {
      // abab 可以删除2次ab 可以删除ba再删除剩下的ab，贪心总是先删除分高的
      var a = 'a'
      var b = 'b'
      var ab = x
      var ba = y
      if(x<y){
          a='b'
          b='a'
          ab=y
          ba=x
      }
      // ab前面的处理已经变成分高的了，优先处理ab，
      // 出现b了，前面有a就累加答案，出现别的了，统计ab
      // ba已经消掉了，ab的次数就是剩余a和b的次数较少的那个
      var cntA = 0
      var cntB = 0
      var ans = 0
      for(c in s){
         when(c){
             b-> if(cntA>0){
                  ans+=ab
                  cntA--
              }else{
                  cntB++
              }
             a-> cntA++
             else->{
                 ans+=min(cntA,cntB)*ba
                 cntA=0
                 cntB=0
             }
         }
      }
      // 最后可能剩一些bbaa
      ans+=min(cntA,cntB)*ba
      return ans
  }
}