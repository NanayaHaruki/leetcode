class Solution {
    fun checkRecord(s: String): Boolean {
        var a = 0
        var l = 0
        for(c in s){
            when(c){
                'A'->{
                    if(++a==2) return false
                    l=0
                }
                'L'->{
                    if(++l==3) return false
                }
                else->{
                    l=0
                }
            }
        }
        return true
    }
}