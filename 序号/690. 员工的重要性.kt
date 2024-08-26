/*
 *	// Definition for Employee.
 *	class Employee {
 *		var id:Int = 0
 *		var importance:Int = 0
 *		var subordinates:List<Int> = listOf()
 *	}
 */

 class Solution {
  fun getImportance(employees: List<Employee?>, id: Int): Int {
      val f = mutableMapOf<Int,Employee>()
      employees.forEach { if(it!=null) f[it.id]=it }
      fun dfs(root:Employee):Int{
          return root.importance+root.subordinates.sumOf { dfs(f[it]!!) }
      }
      return dfs(f[id]!!)
  }
}