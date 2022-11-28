class Solution {
public:
    int singleNumber(vector<int>& nums) {
        int i = 0;
        for(int j:nums){
            i^=j;
        }
        return i;
    }
};