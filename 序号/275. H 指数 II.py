class Solution:
    def hIndex(self, citations: List[int]) -> int:
        n=len(citations)
        l,r=-1,n      
        while l+1<r:
            m=(l+r)//2
            if citations[m]<n-m:# 文献数量超过被引用次数，缩小左边界
                l=m
            else:
                r=m
        return n-r