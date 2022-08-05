/*
执行用时：4 ms, 在所有 C++ 提交中击败了97.69% 的用户
内存消耗：8.1 MB, 在所有 C++ 提交中击败了65.06% 的用户
通过测试用例：987 / 987
*/
class Solution {
 public:
  int lengthOfLongestSubstring(string s) {
    unordered_map<char,int> m;
    int ans=0,l=0,r=0,n=s.size();
    while(r<n){
      char c = s[r];
      int lastIndex;
      if(m.find(c)==m.end()) lastIndex=-1;
      else lastIndex=m[c];
      l=max(l,lastIndex+1); // 如果有重复的，那么左边界从重复位置右边算起；如果重复位置在左边界左边，那么不用管
      ans=max(ans,r-l+1);
      m[c]=r;
      r++;
    }
    return ans;
  }
};

/*
执行用时：64 ms, 在所有 C++ 提交中击败了5.57% 的用户
内存消耗：13.9 MB, 在所有 C++ 提交中击败了5.59% 的用户
通过测试用例：987 / 987
*/
class Solution {
 public:
  int lengthOfLongestSubstring(string s) {
    // 从第一个字符遍历，加入hashset，若加不进去，说明重复
    unordered_set<char> set;
    int ans=0,l=0,r=0,n=s.size();
    while(r<n){
      if(set.emplace(s[r]).second){ // 能加进去，没有重复的，继续向右找，更新最大长度
        ans=max(ans,r-l+1);
        r++;
      }else{
        set.erase(s[l]); // 重复了，左边界右移
        l++;
      }
    }
    return ans;
  }
};

/*
执行用时：568 ms, 在所有 C++ 提交中击败了5.08% 的用户
内存消耗：147.3 MB, 在所有 C++ 提交中击败了5.00% 的用户
通过测试用例：987 / 987
*/
class Solution {
 public:
  int lengthOfLongestSubstring(string s) {
    // 从第一个字符遍历，加入hashset，若加不进去，说明重复
    unordered_set<char> set;
    int ans=0,n=s.length();
    for (int i = 0; i < n-ans; i++) {
      int len = 0;
      for (int j = i; j < n; j++) {
        if (set.emplace(s[j]).second){
          len++;
        }else break;
      }
      set.clear();
      ans=max(ans,len);
    }
    return ans;
  }
};