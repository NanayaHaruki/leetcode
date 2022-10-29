class Solution {
public:
    int countMatches(vector<vector<string>>& items, string ruleKey, string ruleValue) {
        int ans = 0,checkIdx=0;
        if(ruleKey=="color") checkIdx=1;
        else if(ruleKey=="name") checkIdx=2; 
        for(auto & v:items){
            if(v[checkIdx]==ruleValue) ans++;
        }
        return ans;
    }
};