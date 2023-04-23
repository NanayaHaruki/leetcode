class Solution:
    def minHeightShelves(self, books: List[List[int]], shelfWidth: int) -> int:
        # 要让n-1总高度最小,最后一层可以放[k,i]本书,k的值由厚度决定,不能抄过shelfWidth. 
        # 除最后一层,前面的则为同样的子问题,递归条件为i本身

        # dp
        n=len(books)
        dp=[math.inf]*(n+1)
        dp[0]=0
        for i in range(1,n+1):
            w=h=0
            for j in range(1,i+1):
                w+=books[i-j][0]
                if w>shelfWidth:
                    break
                h=max(h,books[i-j][1])
                dp[i]=min(dp[i],dp[i-j]+h)
        return dp[-1]
                


        # @cache
        # def dfs(i):
        #     if i<0:return 0
        #     w=h=0
        #     ans=math.inf
        #     for k in range(i,-1,-1):
        #         if w+books[k][0]>shelfWidth:
        #             break
        #         w+=books[k][0]
        #         h=max(h,books[k][1])
        #         ans=min(ans,dfs(k-1)+h)
        #     return ans
        # return dfs(len(books)-1)