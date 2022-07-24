fun distanceBetweenBusStops(dist: IntArray, s: Int, t: Int): Int {
  val n = dist.size;
  var i = s;
  var j = s;
  var a = 0;
  var b = 0;
  while (i != t) {
    a += dist[i];
    if (++i == n) i = 0;
  }
  while (j != t) {
    if (--j < 0) j = n - 1;
    b += dist[j]
  }
  return minOf(a, b)
}