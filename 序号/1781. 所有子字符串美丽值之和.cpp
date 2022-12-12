class Solution {
 public:
  /** 所有子字符串美丽值之和 美丽值：出现频率最高字符和最低字符出现频次差 */
  int beautySum(string s) {
    // dp 每个以i结尾 长度大于1的字串，都有i个
    int n = s.length(), ans = 0;
    int chars[26];
    for (int i = 0; i < n; i++) {
      memset(chars,0,sizeof(chars));
      int mx = 0;
      for (int j = i; j < n; j++) {    // 顺着来比下面的解法，可以少一层循环，虽然下面一层是n/2 ，三层是 n*(n/2)*(n/2)=(n^3) /4; 顺着来每层多一些，但只要n^2
        mx=max(mx,++chars[s[j]-'a']);
        int mn = 500;
        for(int k=0;k<26;k++){
          if(chars[k]==0) continue;
          mn=min(mn,chars[k]);
        }
        // cout<<i<<','<<j<<'='<<s.substr(i,j-i+1)<<':'<<mx<<','<<mn<<endl;
        ans += (mx - mn);
      }
    }
    return ans;
  }

  // 暴力 遍历所有子字符串，统计频次
  // 时间652 ms 击败 18.88% 内存 6.1 MB 击败 95.80%
  /*
  int beautySum(string s) {
    // 计算以i为末尾的字串
    int n = s.length(), ans = 0;
    for (int i = 1; i < n; i++) {
      for (int j = 0; j < i; j++) {
        int chars[26]{0};
        for (int k = j; k <= i; k++) {
          chars[s[k] - 'a']++;
        }
        int mn = 501, mx = 0;
        for (int cnt : chars) {
          if (cnt == 0) continue;
          mn = min(mn, cnt);
          mx = max(mx, cnt);
        }
        ans += (mx - mn);
      }
    }
    return ans;
  }*/
};