class Solution:
    def restoreMatrix(self, rowSum: List[int], colSum: List[int]) -> List[List[int]]:
        m,n = len(rowSum),len(colSum)
        ans = [[0]*n for _ in range(m)]
        # 将每列放在第一行，依次遍历每一行，从第一列移除一些数让每一行的总和满足要求。 因为每一列都是从这一列往下移动的，所以列的总和不会变化
        for i in range(n):
            ans[0][i]=colSum[i]
        curCol = 0
        for i in range(1,m):
            target = rowSum[i]
            sum=0
            for j in range(curCol,n):
                if sum+ans[0][j]<target:
                    curCol+=1
                    sum+=ans[0][j]
                    ans[i][j]=ans[0][j]
                    ans[0][j]=0
                else:
                    ans[i][j]=target-sum
                    ans[0][j]-=ans[i][j]
                    if ans[0][j]==0:
                        curCol+=1
                    break
        return ans