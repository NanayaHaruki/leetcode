class Solution {
 public:
  /** 一次循环，每个数字前面的数字更大就可以删掉自己。几次循环可以删完 */
  int totalSteps(vector<int>& nums) {
    // 遍历到i的时候，不考虑自身是否应该删除的问题；考虑栈内是否有比i小的数，将他们弹出
    // 要弹出的数中，最大的是最后被弹出的，自身被弹出的步数为最大的那个步数+1
    vector<int> steps(nums.size());
    deque<int> q;
    int ans=0;
    for (int i = 0 ;i< nums.size();i++) {
      int mx = 0;
      while (q.size() && nums[q.back()] <= nums[i]) {
        mx = max(mx, steps[q.back()]);
        q.pop_back();
      }
      if(q.size()){ // 栈内还有，说明自己也会被删
        int curStep = mx+1;
        ans=max(ans,curStep);
        steps[i]=curStep;
      }
      q.emplace_back(i);
    }
    return ans;
  }
};