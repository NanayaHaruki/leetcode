class Solution:
    def longestStrChain(self, words: List[str]) -> int:
        words.sort(key=cmp_to_key(lambda a, b: len(a) - len(b)))

        @cache
        def dfs(i):
            """以 i 为起点的最大字符链长度"""
            if len(words[i]) == len(words[-1]):
                return 1
            mx = 1
            for j in range(i + 1, len(words)):
                lenI, lenJ = len(words[i]), len(words[j])
                if lenI == lenJ:
                    continue
                if lenJ - lenI > 1:
                    break
                # 判断j能否从i 增加一个字符组成,i中每个字符都能在j中找到
                ok = True
                wordI, wordJ = words[i], words[j]
                k = 0
                for _, x in enumerate(wordI):
                    while k < lenJ and wordJ[k] != x:
                        k += 1
                    if k == lenJ:
                        ok = False
                        break
                    k += 1
                if ok:
                    mx = max(mx, 1 + dfs(j))
                    print(f"{wordI} {mx}")
            return mx

        totalMx = 0
        for idx in range(len(words)):
            totalMx=max(totalMx,dfs(idx))
            # print(f"{words[i]} {dfs(i)}")
        return totalMx