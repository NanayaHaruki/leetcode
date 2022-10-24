class Solution {
public:
    /** 分割数组使左边的所有值<=右边，返回left长度 */
    int partitionDisjoint(vector<int>& nums) {
      // 找左边最大值和右边最小值
      const size_t n = nums.size();
      vector<int> l(n,0),r(n,0); // l[i]表示[0,i]之间的最大值；r[i]表示[i,n)之间的最小值
      int mx=-1,mn=1e6+1;
      for(int i=0;i<n;i++){
        mx= max(mx,nums[i]);
        l[i]=mx;
        mn=min(mn,nums[n-1-i]);
        r[n-1-i]=mn;
      }
      int ans=0;
      for(int i=0;i<n;i++){
        if(l[i]<=r[i+1]){
          ans=i;
          break;
        }
      }
      return ans+1;
    }
};