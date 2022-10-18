class Solution {
 public:
  /** 从digits中选数字，可以重复无数次，返回可以《= n的数字个数,digits升序 */
  int atMostNGivenDigitSet(vector<string>& digits, int n) {
    int m = digits.size();
    string nstr = to_string(n);
    int len = nstr.length();
    int ans = 0;
    // 位数小的时候随便排，，每次从m个数中选1个，因为可以重复，所以总共有m^i种可能性
    for (int i = 1; i < len; i++) {
      ans += pow(m, i);
    }
    // 位数相同
    for (int i = 0; i < len; i++) {
      bool prefix=false;
      for (int j = 0; j < digits.size(); j++) {
        int diff = stoi(digits[j]) - (nstr[i] - '0');
        if (diff<0) {
          ans+=pow(m,len-1-i); // 当前位小了，后面所有位数随便排
        }else if(diff==0){
          prefix=true;
          break; // 相同就跳出这一位的选择，判断后面的位数。
        }else{
          return ans; // 更大的就不用判断了
        }
      }
      if(!prefix) return ans; // 能选的数字都比目标小
    }
    // 大的返回了，小的也返回了，走到这的是 可以用digits组成n本身
    return ans+1;
  }
};