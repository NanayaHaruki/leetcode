class Solution {
  vector<int> *tree;
  int n;
  int lowbit(int x){
    return x & -x;
  }
  void update(int x){
    while(x<=n){
      (*tree)[x]++;
      x+=lowbit(x);
    }
  }

  int query(int x){
    int ans=0;
    while(x>0){
      ans+=(*tree)[x];
      x-=lowbit(x);
    }
    return ans;
  }

 public:
  /** 数组前面数比后面数大的对数 */
  int reversePairs(vector<int>& nums) {
    // 遍历到nums[i]的时候，统计前面的比nums[i]大的数，他们的逆序对数+1
    // 将nums离散化，即按照大小排列，查询的时候查的是123..n

    // 离散化，建立映射
    set<int> s;unordered_map<int,int> m;
    n=nums.size();tree = new vector<int>(n+1,0);
    for(int i:nums) s.emplace(i);
    auto it = s.begin(),end=s.end();
    int idx=1,ans=0;
    while(it!=end){
      m.emplace(*it,idx++);
      it++;
    }
    for(int i = n-1;i>=0;i--){ // 从后往前遍历，才能查询到右边有没有比当前小的
      int j = m[nums[i]];
      update(j); // 更新j的值，数里面多了一个j
      ans+=query(j-1); // 检查比j小的数有几个，他们对答案有贡献度
    }
    delete tree;
    return ans;
  }
};