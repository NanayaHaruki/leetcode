class Solution {
public:
    int nthUglyNumber(int n, int a, int b, int c) {
        long lcm_ab  = lcm<long>(a, b);
        long lcm_ac  = lcm<long>(a, c);
        long lcm_bc  = lcm<long>(b, c);
        long lcm_abc = lcm<long>(lcm_ab, c);
        int lo = min({a, b, c}), hi = min(static_cast<long>(lo) * n, 2000000000l);
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (mid / a + mid / b + mid / c - mid / lcm_ab -
                mid / lcm_ac - mid / lcm_bc + mid / lcm_abc < n) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return lo;
    }
};