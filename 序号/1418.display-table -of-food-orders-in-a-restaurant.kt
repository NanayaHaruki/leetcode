class Solution {
    fun displayTable(orders: List<List<String>>): List<List<String>> {
        // 0是名字  1是卓号  2是餐品  转化为 第一行餐品 横向字母数序 纵向卓号升序  餐品数量
        val res = sortedMapOf<Int,SortedMap<String,Int>>() //key为卓号 value的key为餐品 value为数量
        val foodSet = sortedSetOf<String>()
        for (cus in orders){
            val table = cus[1]
            val food = cus[2]
            foodSet.add(food)
            val foodsByTable = res.getOrDefault(table.toInt(), sortedMapOf())
            val curFoodCnt = foodsByTable.getOrDefault(food,0)
            foodsByTable[food]=curFoodCnt+1
            res[table.toInt()]= foodsByTable
        }
        val ans = mutableListOf<MutableList<String>>()
        // 添加第一行 餐品

        val top = mutableListOf("Table")
        for (food in foodSet){
            top.add(food)
        }
        ans.add(top)
        val rowLength = top.size
        // 按卓号升序添加餐品数量
        for ((table,foods) in  res){
            val row = mutableListOf<String>()
            for (i in 0 until rowLength) {
                if (i==0) row.add(table.toString())
                else row.add(foods.getOrDefault(top[i],0).toString())
            }
            ans.add(row)
        }
        return ans
    }
}