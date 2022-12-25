class Solution {
public:
    int minimumBoxes(int n) {
        int x = cbrt(6L * n);
        int ans = x * (x + 1) / 2;
        int max_n = (long) x * (x + 1) * (x + 2) / 6;
        if (max_n > n) {
            max_n -= ans;
            ans -= x; 
        }
       return ans + ceil((-1 + sqrt(1 + 8 * (n - max_n))) / 2);
    }
};

