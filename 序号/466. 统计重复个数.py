class Solution:
    def getMaxRepetitions(self, s1: str, n1: int, s2: str, n2: int) -> int:
        # dp[i] 记录一个s1可以匹配多少个 以s2[i]为起点的字符
        # 然后遍历n1，每次累计从不同字符开始匹配
        dp=[0]*len(s2)
        for i in range(len(s2)):
            k = i
            for j in range(len(s1)):
                if s1[j]==s2[k]:
                    k+=1
                    dp[i]+=1
                if k==len(s2):
                    k=0
                    
        k=ans=0
        for i in range(n1):
            ans+=dp[k] # 这一个s1 可以匹配多少个s2 ，累计到答案
            # 这一个s1过后，匹配到哪个位置了？
            # dp[k]为匹配了几个字符，从k往后加dp[k]就是下一个s1要从哪开始匹配
            k=(k+dp[k])%len(s2)
        return ans//len(s2)//n2
i = Solution().getMaxRepetitions("acb",4,"ab",2)
print(i)