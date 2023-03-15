class Solution:
    def maximalNetworkRank(self, n: int, roads: List[List[int]]) -> int:
        r = defaultdict(set)
        for a,b in roads:
            r[a].add(b)
            r[b].add(a)
        first,fl=set(),0
        second ,sl=set(),0
        # 最大的城市数量如果超过1个，则答案在最大集合之中产生，进一步判断重合路
        # 最大城市数量只有一个，答案在第2大里面选，第2大可能有多个，判断重合路线
        for k,v in r.items():
            lv = len(v)
            if lv>fl:
                second,sl=first,fl
                first,fl={k},lv
                fl=lv
            elif lv==fl:
                first.add(k)
            elif lv> sl:
                second,sl={k},lv
            elif lv==sl:
                second.add(k)
        if len(first)>1:
            for i in first:
                for j in first:
                    if i!=j and i not in r[j]:
                        return fl*2
            return fl*2-1
        elif len(first)==1:
            unionFirst = list(first)[0]
            for i in second:
                if unionFirst not in r[i]:
                    return fl+sl
            return fl+sl-1
        else:
            return 0