class Solution {
    fun moveCols(c1:Int,c2:Int,sb:StringBuilder){
        if(c1<c2){
            repeat(c2-c1){
                sb.append('R')
            }           
        }else if(c1>c2){
            repeat(c1-c2){
                sb.append('L')
            }
        }
    }

    fun moveRows(r1:Int,r2:Int,sb:StringBuilder){
        if(r1<r2){
            repeat(r2-r1){
                sb.append('D')
            }
        }else if(r1>r2){
            repeat(r1-r2){
                sb.append('U')
            }
        }
    }
    fun path(a:Char,b:Char,sb:StringBuilder){
        val r1=(a-'a')/5
        val c1=(a-'a')%5
        val r2=(b-'a')/5
        val c2=(b-'a')%5
        if(a=='z'){
            moveRows(r1,r2,sb)
            moveCols(c1,c2,sb)
        }else{
            moveCols(c1,c2,sb)
            moveRows(r1,r2,sb)
        }
        sb.append('!')
    }
    fun alphabetBoardPath(target: String): String {
        val sb = StringBuilder()
        var p = 'a'
        for(c in target){
            path(p,c,sb)
            p=c
        }
        return sb.toString()
    }
}