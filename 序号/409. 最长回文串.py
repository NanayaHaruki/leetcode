class Solution:
    def longestPalindrome(self, s: str) -> int:
        # 使用已有字符构造最长回文
        # 偶数全部能用，奇数只能用k-1个。加起来即可。如果确实有奇数的字符，那么可以将中间的字符放上        
        c=Counter()
        for x in s:
            c[x]+=1
        ans=oddCnt = 0
        for _,cnt in c.items():
            if cnt &1 :
                oddCnt+=1
                ans+=(cnt-1)
            else:
                ans+=cnt
        return ans+1 if oddCnt else ans