class Solution {
  fun alertNames(keyName: Array<String>, keyTime: Array<String>): List<String> {
    val m = mutableMapOf<String,TreeSet<String>>()
    val ans = mutableSetOf<String>()
    for(i in keyName.indices){
      val name = keyName[i]
      if(ans.contains(name)) continue
      val time= keyTime[i]
      var set = m[name]
      if(set==null){
        set = TreeSet<String>()
      }
      set.add(time)
      m[keyName[i]]=set
      // 找出一小时内的，如果>=3,就可以进答案了
      val minute = time.substring(2)
      val leftTime = if(time[1]=='0'){
        if(time[0]=='0'){
          "00:00"
        }else{
          (time[0]-1)+"9"+ minute
        }
      }else{
        time[0]+(time[1]-1).toString()+ minute
      }
      val rightTime = when(time.substring(0,2)){
        "09"-> "10$minute"
        "19"->"20${minute}"
        "23"->"23:59"
        else->time[0]+(time[1]+1).toString()+minute
      }
      // 判断左边1小时
      var cnt=1
      var preTime = time
      while(true){
        val t = set.lower(preTime)
        if(t==null || t<leftTime) break
        cnt++

        preTime=t
      }
      if(cnt>=3) {
        ans.add(name)
        continue
      }

      // 判断右边一小时
      cnt=1
      preTime=time
      while(true){
        val t = set.higher(preTime)
        if(t==null || t>rightTime) break
        cnt++
        preTime=t
      }
      if(cnt>=3) {
        ans.add(name)
        continue
      }

      // 判断当前time的左右
      val l = set.lower(time)
      val r = set.higher(time)
      if(l!=null && r!=null){
        val lh = l.substring(0,2).toInt()
        val rh = r.substring(0,2).toInt()
        if(lh==rh) {
          ans.add(name)
          continue
        }
        if(rh-1==lh){
          // 判断 r的分钟没有超过l的分钟，那就还在一小时内
          val lm = l.substring(3)
          val rm = r.substring(3)
          if (rm<=lm) {
            ans.add(name)
            continue
          }
        }
      }
    }
    return ans.sorted()
  }
}