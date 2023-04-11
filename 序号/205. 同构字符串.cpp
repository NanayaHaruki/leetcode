class Solution {
public:
    bool isIsomorphic(string s, string t) {
        int ns=s.size(),nt=t.size();
        if(ns!=nt) return false;
        unordered_set<char> dist;
        int dict[256]{0}; 
        for(int i =0;i<ns;i++){
          char cs=s[i],ct=t[i];
          if(dict[cs]){
            if(dict[cs]!=ct) 
              return false;
          }else{
            dict[cs]=ct;
            if(dist.find(ct)!=dist.end()) return false;
            else dist.emplace(ct);
          }
        }
        return true;
    }
};