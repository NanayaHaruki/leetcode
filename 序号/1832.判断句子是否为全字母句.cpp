class Solution {
 public:
  /** 所有子字符串美丽值之和 美丽值：出现频率最高字符和最低字符出现频次差 */
    bool checkIfPangram(string sentence) {
      array<int,26> chars{};
      int cnt=0;
      for(char c:sentence){
        if(chars[c-'a']==0){
          chars[c-'a']++;
          cnt++;
        }
      }
      return cnt==26;
    }
};