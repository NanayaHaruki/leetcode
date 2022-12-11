class Solution {
public:
    int minOperations(vector<int>& nums) {
        int j = nums[0],ans=0;
        for(int i=1;i<nums.size();i++){
            if(nums[i]<=j){
                ans+= (j+1-nums[i]);
                j+=1;
            }else{
                j=nums[i];
            }
        }
        return ans;
    }
};