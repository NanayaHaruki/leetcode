class Solution {
 public:
  vector<int> minOperations(string boxes) {
    int n=boxes.size();
    vector<int> v(n); // dp  右一格的位置需要的操作步数为 左边操作部署 + 左边球左边球个数 + 左边球是否有球 - 左边球右边球个数 
    int l=boxes[0]-'0',r=0,x=0;
    for(int i=1;i<n;i++){
      if(boxes[i]=='1'){
        r++;x+=i;
      }
    }
    v[0]=x;
    for(int i=1;i<n;i++){
      x= x+l-r;
      v[i]=x;
      if(boxes[i]=='1'){
        l++;r--;
      }
    }
    return v;
  }
  // 模拟，双重循环
  // vector<int> minOperations(string boxes) {
  //     vector<int> v;
  //     for(int i=0;i<boxes.length();++i){
  //         if(boxes[i]==1) v.emplace_back(i);
  //     }
  //     vector<int> ans(boxes.length());
  //     int cnt;
  //     for(int i=0;i<boxes.length();i++){
  //         cnt=0;
  //         for(int idx:v){
  //             cnt+=abs(i-idx);
  //         }
  //         ans[i]=cnt;
  //     }
  //     return ans;
  // }
};