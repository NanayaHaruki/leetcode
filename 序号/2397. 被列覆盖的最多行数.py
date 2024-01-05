class Solution:
    def maximumRows(self, matrix: List[List[int]], numSelect: int) -> int:
        m,n=len(matrix),len(matrix[0])
        cur=(1<<numSelect)-1
        limit = 1<<n
        ans=0
        # 将每一行转成二进制数字
        g=[0]*m
        for i,row in enumerate(matrix):
            for j,x in enumerate(row):
                  # g[i]|=x<<(n-1-j)
                g[i]|=x<<j # 倒过来也无所谓
        
        while cur < limit:
            # 遍历每一行，看能覆盖多少
            cover=0
            for i in range(m):
                if g[i] & cur == g[i]:
                    cover+=1
            if cover>ans:ans=cover
            # 找下一个cur
            lb=cur&-cur
            r=cur+lb
            # 右移后导0的个数+2
            # python没有c++ 的 __builtin_ctz() ，java的 numberOfTrailingZeros，利用 x&-x 找最小的1，就可以找到后导0+1的个数了
            cur=((r^cur)>> (lb&-lb).bit_length()+1)|r 
        return ans



            