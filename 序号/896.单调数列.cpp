class Solution {
public:
    bool isMonotonic(vector<int>& nums) {
        int a=nums[0],n=nums.size(),isIncrease=0;
        for(int i=1;i<n;i++){
            int diff = nums[i]-a;
            if(diff==0) continue;
            if(isIncrease==0)isIncrease=diff;
            if((diff>0 && isIncrease>0) || (diff<0 && isIncrease<0)){
                a=nums[i];
                continue;
            }
            return false;
        }
        return true;
    }
};