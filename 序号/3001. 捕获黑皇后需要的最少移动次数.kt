class Solution {
  fun between(a:Int,b:Int,x:Int):Boolean{
      return x>min(a,b) && x<max(a,b)
  }
  fun minMovesToCaptureTheQueen(a: Int, b: Int, c: Int, d: Int, e: Int, f: Int): Int {
      // 车能直接攻击到，判断象有没有夹在中间
      if(a==e){
          return if(c==e && between(b,f,d)) 2 else 1
      }
      if(b==f){
          return if(d==f && between(a,e,c)) 2 else 1
      }
      // 象能攻击到，判断车有没有夹在中间
      if(abs(c-e)==abs(d-f)){
          return if(abs(a-e)==abs(b-f) && between(c,e,a) && between(d,f,b)) return 2 else 1
      }
      return 2
  }
}