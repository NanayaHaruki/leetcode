class Solution {
private:
    int dp[1691];
public:
    int nthUglyNumber(int n) {
        dp[1]=1;
        int index = 2; // 第几个丑数
        int i=1,j=1,k=1; // 和3个质因数乘出来的第几个丑数
        int a,b,c;
        while(index<=n){
            a=dp[i]*2;
            b=dp[j]*3;
            c=dp[k]*5;
            int m = min(a,min(b,c));
            if(m==a) i++;
            if(m==b) j++;
            if(m==c) k++;
            dp[index++]=m;
        }
        return dp[n];
    }
};