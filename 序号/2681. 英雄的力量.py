class Solution:
    def sumOfPower(self, nums: List[int]) -> int:
        # 统计子序列中元素的最大值平方*最小值 之和
        # 先排序
        # a b c d e 
        # 以 b 结尾
        #   以 a 开头的有1个，ab
        #   以 b 开头的有1个，b
        # dp[b]=b^2*(a+b)
        # 以 c 结尾
        #   以 a 开头2个，ac abc 
        #   以 b 开头1个，bc
        #   以 c 开头1个，c
        # dp[c]=c^2*(2a+b+c)

        # 以 d 结尾的子序列中，d为所有子序列最大值
        #   以 a 开头的有4个 ad abd acd abcd，
        #   以 b 开头的有2个 bd bcd
        #   以 c 开头的有1个 cd
        #   以 d 开头的有1个 d
        # dp[d]= d^2*(4a+2b+c+d)                (1)

        # 以e 结尾
        #   以 a 开头，有8个，c3(0) + c3(1) +c3(2)
        #   以 b 开头，有4个
        #   以 c 开头，有2个
        #   以 d 开头，有1个
        # dp[e]=e^2*(8a+4b+2c+d+e)              (2)
        # 观察1式与2式，找出dp[i]与dp[i+1]的转移关系
        # 记最小值之和，为s，s[i]=2*(p)nums[i-1]+nums[i]
        # 遍历时更新这个p
        nums.sort()
        p=ans=0
        m=int(1e9+7)
        for x in nums:
            ans=(ans+(p+x)*x*x)%m
            p=(2*p+x)%m
        return ans