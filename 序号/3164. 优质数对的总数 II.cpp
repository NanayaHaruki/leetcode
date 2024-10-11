class Solution {
public:
    long long numberOfPairs(vector<int>& nums1, vector<int>& nums2, int k) {
        auto d = unordered_map<int,int>();
        for(int x:nums1){
            if(x%k!=0) continue;
            x/=k;
            for(int i=1;i*i<=x;i++){
              if(x%i!=0) continue;
              d[i]++;
              if(i*i<x){
                d[x/i]++;
              }
            }
        }
        long long ans = 0;
        for(int x:nums2){
          ans+=d[x];
        }
        return ans;
    }
};