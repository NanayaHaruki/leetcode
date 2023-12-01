class Solution:
    def firstCompleteIndex(self, arr: List[int], mat: List[List[int]]) -> int:
        # 找到某次涂色后，mat中有一行或一列被涂满了
        # 只需要统计没次涂色后，该行或该列的涂色数量是否等于m或n就知道有没涂满了
        # 首先得定位arr[i]的元素在mat的位置
        m,n=len(mat),len(mat[0])
        rows=[0]*m
        cols=[0]*n
        d={}
        for i in range(m):
            for j in range(n):
                x=mat[i][j]
                d[x]=(i,j)
        for idx,x in enumerate(arr):
            (i,j)=d[x]
            rows[i]+=1
            if rows[i]==n:
                return idx
            cols[j]+=1
            if cols[j]==m:
                return idx
        return -1