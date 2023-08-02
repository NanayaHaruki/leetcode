class Solution:
    def flipgame(self, fronts: List[int], backs: List[int]) -> int:
        d = {}
        st = set()
        n = len(fronts)
        for i in range(n):
            f, b = fronts[i], backs[i]
            if f == b:
                st.add(f)
                continue

            if f in d:
                d[f].append(i)
            else:
                d[f] = [i]
            if b in d:
                d[b].append(i)
            else:
                d[b] = [i]
        ans=math.inf
        for x in d:
            if x not in st:
                ans=min(x,ans)
        return 0 if ans==math.inf else ans