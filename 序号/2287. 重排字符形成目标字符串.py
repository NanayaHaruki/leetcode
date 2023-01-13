class Solution:
    def rearrangeCharacters(self, s: str, target: str) -> int:
        # 从s中找能拍成target的最大个数，统计target需要的字符，选最小满足的即可
        # d = defaultdict(int)
        # for c in target:
        #     d[c] += 1
        # dd = defaultdict(int)
        # for c in s:
        #     if c in d:
        #         dd[c] += 1
        # k,v=d.popitem()
        # ans=dd[k]//v
        # for c in d:
        #     ans = min(ans, dd[c] // d[c])
        # return ans
        sc,tc=Counter(s),Counter(target)
        return min(sc[x]//tc[x] for x in tc)