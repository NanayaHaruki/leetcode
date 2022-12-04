class Solution {
 public:
  /**
   * 至少一个base，每种辅料最多用2次，求最接近target的值，如果多个答案与target差值相同选小的
   * 每种配料最多2次，遍历辅料的时候，再套个for2
   * 就相当于不需要考虑限制了，能装多少装多少。如果超过了之前的最接近的target，就不用继续循环了
   *
   */
  int closestCost(vector<int> &baseCosts, vector<int> &toppingCosts,
                  int target) {
    vector<int> v(target + 1);
    int over = 0x3f3f3f3f, curBase;
    for (int base : baseCosts) {
      if (base > target)
        over = min(over, base);
      else if (base == target)
        return target;
      else
        v[base] = 1;
    }
    for (int k = 0; k < 2; k++) {  // 不加辅料，v[i]是1，加了辅料的，

      for (int top : toppingCosts) {
        for (int i = target; i >=0; i--) {
            curBase = i + top;
            if (v[i]==1 && curBase > target) {
              over = min(over, curBase);
            } 
            if(v[i]==0 && i>top && v[i-top]==1){
              v[i]=1;
            }     
        }
      }
    }
    // 比对大于target的和小于target的谁更近
    for (int i = target; i >=0; i--) { // over很大，i在变成负数之前，就会找到v[i]==1的
      if(target-i>over-target) break;
      if (v[i] == 1) {
        if (target - i <= over - target) {
          return i;
        }
      }
    }
    return over;
  }
};