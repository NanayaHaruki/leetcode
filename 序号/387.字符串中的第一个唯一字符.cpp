class Solution {
 public:
  /** 第一个不重复的字符 */
  int firstUniqChar(string s) {
    int cnt[26]{0};
    
    int len = s.length();
    for (int i = 0; i < len; i++) {
      cnt[s[i]-'a']++;
    }
    for(int i=0;i<len;i++){
      if(cnt[s[i]]==1) return i;
    }
    return -1;
  }
};