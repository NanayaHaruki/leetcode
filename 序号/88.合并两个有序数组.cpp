class Solution {
public:
    /** 非递减，num2合并到num1中去，nums1初始长度为m+n */
    void merge(vector<int>& nums1, int m, vector<int>& nums2, int n) {
      // 双指针
      for(int i = m;i<m+n;i++){
        nums1[i]=nums2[i-m];
      }
      sort(nums1.begin(),nums1.end());
    }
};