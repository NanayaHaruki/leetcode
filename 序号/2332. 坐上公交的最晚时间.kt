class Solution {
  fun latestTimeCatchTheBus(buses: IntArray, passengers: IntArray, capacity: Int): Int {
      buses.sort()
      passengers.sort()
      var i = 0
      var ans = min(buses[0],passengers[0]-1) // 第1个上车，下面遍历时不断更新可以上车的最晚时间
      for (bus in buses){
          var cur = 0 // 这辆bus装了几个人
          while (i<passengers.size && cur<capacity && passengers[i]<=bus){
              if(i==0) ans = max(ans,passengers[0]-1)
              else if(passengers[i]-passengers[i-1]>1) ans = max(ans,passengers[i]-1)
              cur++
              i++
          }
          if(cur<capacity){
              // 没满，最后一个不是bus出发时间，那我可以这辆bus出发时间上车
              if (i==0 || (i>0 && passengers[i-1]!=bus)) ans = bus

          }
      }
      return ans
  }
}