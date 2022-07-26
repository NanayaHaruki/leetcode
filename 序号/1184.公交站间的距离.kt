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

/**
int distanceBetweenBusStops(vector<int> &distance, int start, int destination) {
// 算2遍，要么顺时针 要么逆时针
if (destination == start) return 0;
int n = distance.size();
vector<int> pre(n+1);
for (int i = 0; i < n; i++) {
pre[i + 1] = distance[i] + pre[i];
}
int ma = max(start, destination), mi = 0;
if (ma == start)
mi = destination;
else
mi = start;
int a = pre[ma] - pre[mi];
int b = pre[n] - a;
return min(a, b);
}
 * */