class Solution {
private:
  vector<string> split(string s){
    vector<string> v;
    if(s.length()==1) return {s};
    if(s[0]=='0' && s[s.length()-1]=='0') return {}; // 头尾都是0，满足不了  
    if(s[0]=='0'){
      s.insert(s.begin()+1,'.');
      v.emplace_back(s);
      return v;
    }

    if(s[s.length()-1]=='0') return {s}; // 尾0的不能有小数点
    v.emplace_back(s);
    int n= s.length();
    for(int i = 1;i<n;i++){
      string tmp{s};
      tmp.insert(tmp.begin()+i,'.');
      v.emplace_back(tmp);
    }
    return v;
  }
public:
    /** 分成两个数字 */
    vector<string> ambiguousCoordinates(string s) {
      // 将字符串分成两部分,对左右两部分判断各自能分成哪些数字，求笛卡尔积
      s=s.substr(1,s.length()-2);
      int n = s.length();
      vector<string> ans;
      for(int i = 1;i<n;i++){ // i为截多长
        string l=s.substr(0,i),r=s.substr(i);
        vector<string> ls=split(l),rs=split(r);
        if(ls.empty() || rs.empty()) continue;
        for(auto &l:ls){
          for(auto &r:rs){
            ans.emplace_back('('+l+", "+r+')');
          }
        }
      }
      return ans;
    }
};