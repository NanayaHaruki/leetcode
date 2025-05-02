class Solution {
    fun pushDominoes(dominoes: String): String {
        val n = dominoes.length
        val sb = StringBuilder(n)
        var p = '$'
        var j = -1
        for (i in dominoes.indices){
            when(dominoes[i]){
                '.'->continue
                'L'->{
                    if(p =='$' || p=='L'){
                        repeat(i-j) {sb.append('L')}
                    }else{
                        if((i-j)%2==0){
                            repeat((i-j)/2-1){sb.append('R')}
                            sb.append('.')
                            repeat((i-j)/2){sb.append('L')}
                        }else{
                            repeat((i-j+1)/2-1) {sb.append('R')}
                            repeat((i-j+1)/2){sb.append('L')}
                        }
                    }
                    p='L'
                    j=i
                }
                'R'->{
                    if(p=='$' || p=='L'){
                        repeat(i-j-1) {sb.append('.')}
                        sb.append('R')
                    }else{
                        repeat(i-j){sb.append('R')}
                    }
                    p='R'
                    j=i
                }
            }
        }
        when(p){
            '$','L'->repeat(n-j-1){sb.append('.')}
            else-> repeat(n-j-1){sb.append('R')}
        }
        return sb.toString()
    }
}