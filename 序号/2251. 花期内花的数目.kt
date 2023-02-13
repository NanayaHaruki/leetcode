class Solution {
  
  fun fullBloomFlowers(flowers: Array<IntArray>, persons: IntArray): IntArray {
    // 先用差分记录花开花落，再用前缀和记录几天前开了多少花，最后用二分求特定时间点花开数量
    val map = TreeMap<Int,Int>() // key 表示时间，value 表示开花或落花的数目
    for((start,end) in flowers){
      map[start] =  map.getOrDefault(start,0)+1
      map[end+1] = map.getOrDefault(end+1,0) -1 // end那一天花还是开着的，所以要+1
    }
    val saki = TreeMap<Int,Int>() // key 表示时间，value 表示开花的数量
    var cnt = 0
    for((time,n) in map){
      cnt+=n
      saki[time]=cnt
    }
    val n = persons.size
    val ans = IntArray(n)
    for(i in persons.indices){
      var entry = saki.floorEntry(persons[i])
      if(entry!=null && entry.key==persons[i]){
        ans[i]=entry.value
        continue
      }
      entry = saki.lowerEntry(persons[i])
      if(entry!=null){
        ans[i]=entry.value
      }
    }
    return ans
  }
}