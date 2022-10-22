class Solution {
  public:
  int jobScheduling(vector<int>& startTime, vector<int>& endTime,
                    vector<int>& profit) {
    int n = startTime.size();
    // dp[i]表示前i个工作能获得的最大利润
    // 第i个工作能做的前提是，在start[i-1]开始前，其他工作全部结束。找到上一份工作结束时间最接近start[i-1]时的利润
    // 因为需要根据结束时间找工作，先排个序
    vector<vector<int>> jobs(n);
    for (int i = 0; i < n; i++) {
      jobs[i]={startTime[i], endTime[i], profit[i]};
    }
    sort(jobs.begin(), jobs.end(), [](const vector<int> &a,const vector<int> b)->bool{return a[1]<b[1];});
    vector<int> dp(n + 1);
    for(int i = 1;i<=n;i++){
      // dp[i]为干了前几个工作中的最大利润，当前遍历到的工作索引为i-1
      int a = dp[i-1]; // 不干这个工作，利润与上一次工作相同；
      int diff = upper_bound( // upper_bound找出之前的工作中结束时间大于当前工作开始时间中最小的
        jobs.begin(),
        jobs.begin()+i-1, // 当前工作索引为jobs中的i-1，搜索结束时间《=开始时间的工作，不包括当前工作
        jobs[i-1][0], // 开始时间
        [&](int i,const vector<int> &v)->bool{
        return i<v[1];
      })-jobs.begin();
      int preJobCnt = it-jobs.begin(); // preJobCnt 在i-1之前有几个工作，结束时间<=当前工作开始时间
      int b = dp[preJobCnt]+jobs[i-1][2];
      dp[i]=max(a,b);
    }
    return dp[n];
  }
};