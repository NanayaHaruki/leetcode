class Solution:
    def maxStudents(self, seats: List[List[str]]) -> int:
        m,n=len(seats),len(seats[0])
        a=[ sum((x=='.')<<j for j,x in enumerate(row))for row in seats  ]
        @cache
        def dfs(i,j):
            ''' i 是第几行，j是这一行的情况,某个比特上是1表示有座位 '''
            # 已经第一行了，贪心
            if i==0:
                ans=0
                while j:
                    ans+=1
                    lowerBit = j&-j 
                    j&=~(lowerBit*3) # 将最低位和它左边的位置变成0 ,lowerbit*2 就是左移一位，lowerbit & (lowerbit <<1) 与 lowerbit*3 是一样的
                return ans
            # 遍历座位的子集,位运算遍历子集
            # while s:
            #   s=(s-1)&j
            s=j
            ans=dfs(i-1,a[i-1]) # i行不坐人了，对i-1行无影响
            while s:
                # 当前是这个坐法，上一行会被影响，某列坐人了，上一行这一列的左右都不能 再坐
                # 如果s有连坐的，不合法，直接下一个子集
                if (s&(s>>1))==0:
                    t=a[i-1]&~(s<<1 | s>>1)
                    ans=max(ans,dfs(i-1,t)+s.bit_count())
                s=(s-1)&j
            return ans
        return dfs(m-1,a[m-1])