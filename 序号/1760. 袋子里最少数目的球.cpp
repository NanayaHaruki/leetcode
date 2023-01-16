class Solution {
public:
    int minimumSize(vector<int>& nums, int maxOperations) {
      int l=0,r=1+*max_element(nums.begin(),nums.end());
      while(l+1<r){
        int m = l+(r-l)/2;
        cout<<l<<','<<r<<','<<m<<endl;
        int operation=0;
        // 将nums中所有数操作到《=m， i*m需要操作（i-1）次，2m操作一次变成m和m；3m操作一次变成2m和m，再将2m操作成m和m；
        // (0,m] 操作0次，（m,2m]操作1次
        for(const int i:nums){
          operation+=(i-1)/m;
          if(operation>maxOperations) break;
        }
        if (operation<=maxOperations){
          // ok,操作次数够，尝试更小的
          r=m;
        }else{
          l=m;
        }
      }
      return r;
    }
};