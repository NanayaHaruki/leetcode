class Solution {
public:
    /** 判断是否元音数目相同 */
    bool halvesAreAlike(string s) {
      unordered_set<char> set{'a','e','i','o','u','A','E','I','O','U'};
      int len = s.length(),h=len/2,cnt=0;
      for(int i = 0;i<len;i++){
        if(set.find(s[i])!=set.end()){
          if(i<h) cnt++;
          else cnt--;
        }
      }
      return cnt==0;
    }
};