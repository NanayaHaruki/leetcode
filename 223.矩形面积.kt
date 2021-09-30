import kotlin.math.*
class Solution() {
    fun computeArea(ax1: Int, ay1: Int, ax2: Int, ay2: Int, bx1: Int, by1: Int, bx2: Int, by2: Int): Int {
        var diffx = min(ax2,bx2)-max(ax1,bx1)
        if (diffx<0) diffx = 0

        var diffy = min(ay2,by2)-max(ay1,by1)
        if (diffy<0) diffy = 0
        return (ax2-ax1)*(ay2-ay1)+(bx2-bx1)*(by2-by1)-diffx*diffy
    }
}