class Solution:
    def numTimesAllBlue(self, flips: List[int]) -> int:
        '''依次修改每一位，返回修改第i位后，前面都是1的次数'''
        # 因为是全排列，遍历到x的时候，如果前面有空的，那么最大值必然大于当前值。 刚好是当前值时，说明前缀都是1了
        mx=ans=0
        for i,x in enumerate(flips):
            mx=max(mx,x)
            ans+=mx==(i+1)
        return ans


        # bit,
        # n=len(flips)
        # bit = [0]*(n+1)

        # def lowerbit(x):
        #     return x&-x
        
        # def update(i,x):
        #     while i<=n:
        #         bit[i]+=x
        #         i+=lowerbit(i)

        # def query(i):
        #     ans=0
        #     while i>0: # bit 管辖[1,i] 不能为0
        #         ans+=bit[i]
        #         i-=lowerbit(i)
        #     return ans
    
        # ans=0
        # for i,x in enumerate(flips):
        #     update(x,1) # 更新树
        #     q = query(i+1)
        #     if q==i+1:
        #         ans+=1
        # return ans