class Solution:
    def longestDecomposition(self, text: str) -> int:
        def dfs(i,j):
            if i>j:
                return 0
            if i ==j:
                return 1
            if i+1==j:
                return 1 if text[i]!=text[j] else 2
            if text[i]==text[j]:
                return dfs(i+1,j-1)+2
            mid=(i+j)//2
            for k in range(i,mid+1):
                if text[k]==text[j]:
                    if text[i:k+1]==text[j-(k-i):j+1]:
                        return 2+dfs(k+1,j-(k-i)-1)
            return 1
        return dfs(0,len(text)-1)