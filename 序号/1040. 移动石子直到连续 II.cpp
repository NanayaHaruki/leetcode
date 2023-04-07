class Solution {
public:
    vector<int> numMovesStonesII(vector<int>& stones) {
      // 移动的最多次数，
      // 将端点内的每个空位填满
      // 数一下[0,n-2]有多少个空位，不断将外面的石子放进最靠近外侧的空位。
      // 空位有stones[n-2]-stones[0]-1个，里面的石子有n-3个，排除掉了（0，n-2，n-1）这三个
      // [1,n-1]同理
      int n = stones.size();
      sort(stones.begin(),stones.end());
      int a=stones[n-2]-stones[0]-1-(n-3),b=stones[n-1]-stones[1]-1-(n-3);
      int mx = max(a,b);
      if(a==0||b==0){
        // 没空位，要将原端点往右挪出空位，再将外面那个石子放进来
        return {min(2,mx),mx};
      }

      // 最少移动次数
      // 一次到位，放到能让石子连续的位置上去。 最少移动就要让长度为n的窗口内本来就有最多的石子
      int cnt=0,start=0;
      for(int end=0;end<n;++end){
         for(;stones[start]+n<=stones[end];start++){}
         cnt=max(cnt,end-start+1);// start,end是索引，计算出它们间有多少石子； stoens[start],stones[end] 之间有固定的n个位置
      }
      return {n-cnt,mx};
    }
};