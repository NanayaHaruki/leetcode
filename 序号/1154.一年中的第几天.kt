class Solution {
    fun dayOfYear(date: String): Int {
        val (year,month,day) = date.split("-")
        val c = Calendar.getInstance().apply {
            set(Calendar.YEAR,year.toInt())
            set(Calendar.MONTH,month.toInt()-1)
            set(Calendar.DATE,day.toInt())
        }
        val first = Calendar.getInstance().apply {
            set(year.toInt(),0,1,0,0,0)
        }
        val diffMillis = c.timeInMillis - first.timeInMillis
        return (diffMillis / 1000 / 3600 / 24).toInt() + 1
    }
}