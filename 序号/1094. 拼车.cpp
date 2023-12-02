class Solution {
public:
    bool carPooling(vector<vector<int>>& trips, int capacity) {
        // 用差分，再遍历
        map<int,int> d;
        for(vector<int> & v:trips){
            d[v[1]]+=v[0];
            d[v[2]]-=v[0];
        }
        int ans=0;
        for(auto & p:d){
            // cout<<p.first<<','<<p.second<<endl;
            ans+=p.second;
            if(ans>capacity){
                return false;
            }
        }
        return true;
    }
};