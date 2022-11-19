class Solution {
public:
    int largestAltitude(vector<int>& gain) {
        int ans = 0,next=0;
        for(int i:gain){
            next+=i;
            ans = max(ans,next);
        }
        return ans;
    }
};