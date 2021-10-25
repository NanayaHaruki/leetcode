open abstract class VersionControl{
    fun isBadVersion(v:Int) = v>=4
    abstract  fun firstBadVersion(n:Int):Int

}
class Solution :VersionControl(){
    override fun firstBadVersion(n: Int) : Int {
        var l = 1
        var r = n
        while(l<=r){
            val mid = l+(r-l)/2
            val isBad = isBadVersion(mid)
            if(isBad){
                r = mid-1
            }else {
                l = mid+1
            }
        }
        return if (isBadVersion(r + 1)) {
            r+1
        }else {
            -1
        }
    }
}