

import kotlin.math.min
import kotlin.booleanArrayOf


fun main() {
    val a = arrayOf(
        intArrayOf(1,1,1),intArrayOf(1,0,1),intArrayOf(1,1,1))
    val i =Solution1().largest1BorderedSquare(a)
    print(i)
}

class Solution1 {
    lateinit var rowPs :Array<IntArray>
    lateinit var colPs :Array<IntArray>
    fun check(x:Int):Boolean{
        // 用前缀和判断四条边是否都是1
        for(i in x until rowPs.size){
            for(j in x until rowPs[0].size){
                if(rowPs[i][j]-rowPs[i-x][j]==x && rowPs[i][j]-rowPs[i][j-x]==x && colPs[i][j]-colPs[i-x][j]==x && colPs[i][j]-colPs[i][j-x]==x){
                    continue
                }else{
                    return false
                }
            }
        }
        return true
    }
    fun largest1BorderedSquare(grid: Array<IntArray>): Int {
        val m = grid.size
        val n = grid[0].size
         rowPs = Array(m+1){IntArray(n+1)}
         colPs = Array(m+1){IntArray(n+1) }
        for(i in 1 .. m){
            for(j in 1.. n){
                rowPs[i][j]=rowPs[i][j-1]+grid[i-1][j-1]
                colPs[i][j]=colPs[i-1][j]+grid[i-1][j-1]
            }
        }
        var l = 0;var r = kotlin.math.min(m,n)+1
        while(l+1<r){
            val mid = (l+r)/2
            println(mid)
            if(check(mid)){
                l=m
            }else{
                r=m
            }
        }
        return l*l
    }
}

    