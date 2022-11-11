class Solution {
public:
    /** 判断a能否由b构成，每个字符用一次 */
    bool canConstruct(string a, string b) {
        if(a.length()>b.length()) return false;
        int cnt[26]{0};
        for(char c:b){
          cnt[c-'a']++;
        }
        for(char c:a){
          if(cnt[c-'a']){
            cnt[c-'a']--;
          }else{
            return false;
          }
        }
        return true;
    }
};