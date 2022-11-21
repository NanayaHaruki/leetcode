class Solution {
 public:
  /**计算s2是否包含s1的排列,s1打乱顺序后是s2的字串*/
  bool checkInclusion(string s1, string s2) {
    // 滑动窗口，检查固定长度内是否为s1的排列
    int n = s1.length(), m = s2.length();
    if(n>m) return false;
    int cs1[26]{0},cs2[26]{0};
    for(int i = 0;i<n;i++){
      cs1[s1[i]-'a']++;
      cs2[s2[i]-'a']++;
    }
    for(int i=n;i<m;i++){
      bool eq=true;
      for(int j=0;j<26;j++){
        if(cs1[j]!=cs2[j]) {
          eq=false;
          break;
        }
      }
      if(eq) return true;
      cs2[s2[i]-'a']++;
      cs2[s2[i-n]-'a']--;
    }
    for(int j=0;j<26;j++){
        if(cs1[j]!=cs2[j]) {
          return false;
        }
      }
    return true;
  }
};