class Solution:
    def numTilePossibilities(self, tiles: str) -> int:
        # dp
        cnts=Counter(tiles)
        n,m=len(tiles),len(cnts)
        # 定义dp[i][j] 为前i种字符，组成长度j的序列种数
        # 
        dp=[[0]*(n+1) for _ in range(m+1)]
        dp[0][0]=1
        for i,cnt in enumerate(cnts.values(),1):
            for j in range(n+1):
                for k in range(1+min(j,cnt)):
                    dp[i][j]+=dp[i-1][j-k]*math.comb(j,k) # 当前选了k个，前面选j-k个
        return sum(dp[m][1:])

        # 回溯
        # cnts=Counter(tiles)
        # self.ans=0
        # def dfs():
        #     for k,v in cnts.items():
        #         if v:
        #             self.ans+=1
        #             cnts[k]-=1
        #             dfs()
        #             cnts[k]+=1
        # dfs()
        # return self.ans


        # 直接调库
        # n=len(tiles)
        # ans=0
        # for i in range(1,n+1):
        #     ans+=len(set(itertools.permutations(tiles,i)))
        # return ans
