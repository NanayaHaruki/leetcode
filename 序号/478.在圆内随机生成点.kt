class Solution(val radius: Double,val x_center: Double,val y_center: Double) {
  fun randPoint(): DoubleArray {
    var x = 0.0;var y=0.0;
    while(true) {
      x =Random.nextDouble(-radius,radius)
      y = Random.nextDouble(-radius,radius)
      if (x*x+y*y<radius*radius) break
    }
    return doubleArrayOf(x+x_center,y+y_center)
  }
}