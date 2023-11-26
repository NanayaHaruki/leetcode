class Solution {
public:
    int uniqueLetterString(string s) {
        vector<vector<int>> v(26,{-1});
        size_t sz=s.size();
        for(size_t i=0;i<sz;++i){
            v[s[i]-'A'].emplace_back(i);
        }
        for (vector<int> & indices:v)
        {
           indices.emplace_back(sz);
        }
        int ans=0;
        for(vector<int> & indices:v){
            for (size_t i = 1; i < indices.size()-1; i++)
            {
                ans+=(indices[i]-indices[i-1])*(indices[i+1]-indices[i]);
            }
            
        }
        return ans;      
    }
};