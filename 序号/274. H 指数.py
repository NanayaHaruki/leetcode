class Solution:
    def hIndex(self, citations: List[int]) -> int:
        citations.sort()
        n=len(citations)
        l,r=-1,n+1
        while l+1<r:
            mid=(l+r)//2
            # 引用量大于mid的书看有没有mid本，有就说明mid是合法值，尝试更大的
            idx = bisect.bisect_left(citations,mid)
            if n-idx>=mid:
                l=mid
            else :r=mid
        return l