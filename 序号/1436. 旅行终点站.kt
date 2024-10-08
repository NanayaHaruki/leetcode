class Solution {
  fun destCity(paths: List<List<String>>): String {
      val fromCity = mutableSetOf<String>()
      val toCity = mutableSetOf<String>()
      for((a,b) in paths) {
          fromCity.add(a)
          toCity.add(b)    
      }
      return (toCity-fromCity).first()
  }
}