
class Solution {
  int n;
  char shift(char c){
    if(c>='a') return c-32;
    else return c+32;
  }
  void backTrace(vector<string>& ans, string& s, int j) {
    ans.emplace_back(s);
    for (int i = j; i < n; i++) {
      if(s[i]<='9') continue;
      s[i] =shift(s[i]);
      backTrace(ans, s, i + 1);
      s[i] =shift(s[i]);
    }
  }

 public:
  vector<string> letterCasePermutation(string s) {
    vector<string> ans;
    n = s.length();
    backTrace(ans, s, 0);
    return ans;
  }
};

// class Solution {
//   /** 大小写转换 a97 A65 */
//   char shift(char c){
//     if(c<'a') return c+32;
//     else return c-32;
//   }
// public:
//     /** 大小写、数字，字母转变大小写，得到新的字符串，返回所有字符串 */
//     vector<string> letterCasePermutation(string s) {
//       // 字符串由
//         vector<string> ans{s};
//         int n = s.length();
//         for(int i = 0;i<n;i++){
//           if(s[i]<='9') continue; // 数字无法转换
//           int curSize = ans.size();
//           for(int j=0;j<curSize;j++){// 取出之前转换过的，将当前位置转换了之后再塞进去
//             string tmp{ans[j]};
//             tmp[i]=shift(s[i]);
//             ans.emplace_back(tmp);
//           }
//         }
//         return ans;
//     }
// };