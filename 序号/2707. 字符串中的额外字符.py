class Solution:
    def minExtraChar(self, s: str, dictionary: List[str]) -> int:
        st=set(dictionary)
        @cache
        def dfs(i):
            if i<0:return 0
            ans=dfs(i-1)+1
            for j in range(i+1):
                if s[j:i+1] in st:
                    ans=min(ans,dfs(j-1))
            # print(i,ans)
            return ans
        return dfs(len(s)-1)

        # st=set(dictionary)
        # n=len(s)
        # f=[math.inf]*n
        # f[0]=0 if s[0] in st else 1
        # for i in range(n):
        #     if s[:i+1] in st:
        #         f[i]=0
        #         continue
        #     for j in range(i):
        #         if s[j+1:i+1] in st:
        #             f[i]=min(f[i],f[j])
        #         else:
        #             f[i]=min(f[i],f[j]+i-j)
        # return f[-1]