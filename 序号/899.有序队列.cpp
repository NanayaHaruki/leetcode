class Solution {
public:
     string orderlyQueue(string s, int k) {
        if(k>1) {
          sort(s.begin(),s.end());
          return s;
        }else{
          int n = s.length();
          s+=s;
          string_view sv(s),ans(sv);
          for(int i = 0;i<n;i++){
            auto tmp = sv.substr(i,n);
            ans=min(ans, sv.substr(i,n));
          }

          return string{ans};
        }
    }
};