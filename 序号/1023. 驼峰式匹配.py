class Solution:
    def camelMatch(self, queries: List[str], pattern: str) -> List[bool]:
        # pattern 都要按顺序在queries中找到，且找到最后一个字符后，queries后面不能再有大写字母

        def match(w: str, p: str):
            j ,m= 0,len(w)
            for i, x in enumerate(p):
                while j < m :
                    if 'A'<=w[j]<='Z' :
                        if w[j]==x:
                            break
                        return False
                    else:
                        if w[j]==x:
                            break
                        j += 1
                if j == m:
                    return False
                j+=1
            for i in range(j + 1, m):
                c = w[i]
                if "A" <= c <= "Z":
                    return False
            return True

        ans = [False] * len(queries)
        for k, w in enumerate(queries):
            ans[k] = match(w, pattern)
        return ans