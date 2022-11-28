class Solution {
public:
    bool isPowerOfTwo(int n) {
      int i = n & (-n);
      return i==n;
    }
};