class Solution {
  fun parseLog(log:String):IntArray{
    val splits = log.split(':')
    return intArrayOf(splits[0].toInt(),if(splits[1][0]=='s')0 else 1,splits[2].toInt())
  }
  fun exclusiveTime(n: Int, logs: List<String>): IntArray {
    // 将log入栈，如果自己是start，前一个如果是start，前一个自增差值。前一个是end不管，说明cpu空闲
    //           如果自己是end，如果前一个id相同，则该id自增，如果id不同，则该id自增时间差值
    val q = ArrayDeque<IntArray>()
    val ans = IntArray(n)
    for (log in logs){
      val parseLog = parseLog(log)
      if(parseLog[1]==0){ // 开始任务，直接压栈
        q.add(parseLog)
      }else{ // 结束任务，弹栈并计算该任务耗时。同时将下一个栈顶任务耗时扣除掉当前任务的耗时
        val latestLog = q.removeLast()
        val curTaskCost = parseLog[2]-latestLog[2]+1
        ans[parseLog[0]]+=curTaskCost
        if(q.isNotEmpty()){
          ans[q.last[0]]-=curTaskCost
        }
      }
    }
    return ans
  }
}