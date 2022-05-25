class Solution {
public:
    int findSubstringInWraproundString(string p) {
        int ans = 0;
        vector<int> dp(26);
        int len = p.length();
        int max = 0;
        for (int i = 0; i < len; ++i) {
            if (i == 0) max = 1;
            else {
                if (p[i] - p[i - 1] == 1 || (p[i] == 'a' && p[i - 1] == 'z')) {
                    max++;
                }else {
                    max=1;
                }
            }
            dp[p[i]-'a'] = std::max(max,dp[p[i]-'a']);
        }
        return accumulate(dp.begin(), dp.end(),0);
    }
};