class Solution:
    def maxSizeSlices(self, slices: List[int]) -> int:
        n=len(slices)
        k=n//3
        def calc(start,end):
            pre = [[[0]*(k+1) for _ in range(2)] for _ in range(end+1)] # pre[0][k]  一维表示拿没拿，二维表示还可以拿几次
            pre[start][1][k-1]=slices[start]
            for i in range(start+1,end+1):
                for j in range(k):
                    pre[i][0][j]=max(pre[i-1][1][j],pre[i-1][0][j])
                    pre[i][1][j]=pre[i-1][0][j+1]+slices[i]
            return max(max(pre[-1][0]),max(pre[-1][1]))
        return max(calc(0,n-2),calc(1,n-1))