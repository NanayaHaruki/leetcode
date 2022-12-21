/**时间0 ms击败100%内存5.8 MB击败71.71%*/
class Solution {
 public:
  int maximumScore(int a, int b, int c) {
    // 尽量避免让堆到0，每次应当挑选最多的两堆。 a>=b>=c
    // b+c<=a,每次都让b和c与a匹配，直到拿光，次数为b+c
    // b+c>a, 每次拿bc中大的和c匹配，因为bc都小于a，bc总会变成相等或差1的状态。c拿光之后，bc互相匹配
    //   b和a匹配x次，c和a匹配y次，x+y=c;  
    //   bc互相匹配， 匹配次数为 ((b-x)+(c-y))/2
    //   总匹配次数 c+（(b+c)-(x+y))/2=(a+b+c)/2
    vector<int> v{a,b,c};
    sort(v.begin(),v.end());
    if(v[0]+v[1]<=v[2]){
      return v[0]+v[1];
    }else{
      return reduce(v.begin(),v.end())/2;
    }
  }
};

/** 模拟 时间20 ms击败29.27%内存5.8 MB击败38.5%*/
// class Solution {
// private :
//   void op(int &a,int& b,int &c){
//     if(a>=b&&a>=c){
//       a--;
//       if(b>=c){
//         b--;
//       }else{
//         c--;
//       }
//     }else if(b>=a&&b>=c){
//       b--;
//       if(a>=c) a--; else c--;
//     }else if(c>=b&&c>=a){
//       c--;
//       if(b>=a) b--;else a--;
//     }
//   }
//  public:
//   int maximumScore(int a, int b, int c) {
//     int ans = 0;
//     while ((a && b) || (a && c) || (b && c)) {
//        ans++;
//       op(a,b,c);
//     }
//     return ans;
//   }
// };