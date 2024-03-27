class Solution:
    def countWays(self, ranges: List[List[int]]) -> int:
        # 先将必须在一个组的区间合并，统计有多少个合并后的区间
        ranges.sort()
        cnt = 0
        p = -1
        for a,b in ranges:
            if a>p:
                cnt+=1
                p=b
            else:
                p=max(p,b)
        return pow(2,cnt,1_000_000_007)