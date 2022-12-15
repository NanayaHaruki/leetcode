class Solution {
public:
    int getLucky(string s, int k) {
      deque<int> v;
      for(char c:s){
        int i =c-'a'+1;
        if(i>=20){
          v.emplace_back(2);
          v.emplace_back(i-20);
        }else if(i>=10){
          v.emplace_back(1);
          v.emplace_back(i-10);
        }else{
          v.emplace_back(i);
        }
      }
      int ans = 0;
      for(int i=0;i<k;++i){
        ans=reduce(v.begin(),v.end());
        if(i==k-1) break;
        v.clear();
        while(ans>0){
          v.emplace_front(ans%10);
          ans/=10;
        }
      }
      return ans;
    }
};