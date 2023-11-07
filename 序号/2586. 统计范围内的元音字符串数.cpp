class Solution {
public:
    int vowelStrings(vector<string>& words, int left, int right) {
        set<char> s{'a','e','i','o','u'};
        int ans=0;
        for (size_t i = left; i <=right; i++)
        {
          string_view sv = words[i];
          if(s.contains(*sv.begin()) && s.contains(*sv.rbegin())){
            ans++;
          }
        }
        return ans;              
    }
};