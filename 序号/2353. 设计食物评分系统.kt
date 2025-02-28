class FoodRatings(foods: Array<String>, cuisines: Array<String>, ratings: IntArray) {
  val cuisineMap = mutableMapOf<String,TreeSet<Food>>()
  val names = mutableMapOf<String,Food>()
  data class Food(val name:String,val cuisine:String,var rate:Int):Comparable<Food>{
      override fun compareTo(other: Food): Int {
          if (rate!=other.rate) return other.rate-rate
          return name.compareTo(other.name)
      }

  }
  init {
      val n = foods.size
      for (i in 0 until n){
          val food = Food(foods[i],cuisines[i],ratings[i])
          names[food.name]=food
          if(cuisineMap.containsKey(food.cuisine)){
              cuisineMap[food.cuisine]!!.add(food)
          }else{
              cuisineMap[food.cuisine]=TreeSet<Food>().apply { add(food) }
          }
      }
  }
  fun changeRating(name: String, newRating: Int) {
      val food  = names[name]!!
      val  tree = cuisineMap[food.cuisine]!!
      var start = tree.floor(food)!! // 二分找旧分数的食品

      tree.remove(start)
      start.rate=newRating
      tree.add(start)
  }

  fun highestRated(cuisine: String): String {
      // 按烹饪类别排序，用map key存烹饪方式，value存按分数降序拍
      return cuisineMap[cuisine]!!.first().name
  }
}

/**
* Your FoodRatings object will be instantiated and called as such:
* var obj = FoodRatings(foods, cuisines, ratings)
* obj.changeRating(food,newRating)
* var param_2 = obj.highestRated(cuisine)
*/