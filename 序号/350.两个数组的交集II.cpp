class Solution {
 public:
  // vector<int> intersect(vector<int>& nums1, vector<int>& nums2) {
  //   sort(nums1.begin(), nums1.end());
  //   sort(nums2.begin(), nums2.end());
  //   vector<int> v;
  //   set_intersection(nums1.begin(), nums1.end(), nums2.begin(), nums2.end(),
  //                    back_insert_iterator(v));
  //   return v;
  // }
  vector<int> intersect(vector<int>& nums1, vector<int>& nums2) {
    sort(nums1.begin(), nums1.end());
    sort(nums2.begin(), nums2.end());
    vector<int> v;
    int m = nums1.size(), n = nums2.size(), i = 0, j = 0;
    while (i < m && j < n) {
      if (nums1[i] < nums2[j]) {
        i++;
        continue;
      }
      if (nums1[i] > nums2[j]) {
        j++;
        continue;
      }
      v.emplace_back(nums1[i]);
      i++;
      j++;
    }
    return v;
  }
};