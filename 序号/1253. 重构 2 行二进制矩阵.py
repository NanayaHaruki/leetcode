class Solution:
    def reconstructMatrix(self, upper: int, lower: int, colsum: List[int]) -> List[List[int]]:
        n=len(colsum)
        ans=[[0]*n for _ in range(2)]
        for i,x in enumerate(colsum):
            if x==0:continue
            if x==2:
                if upper and lower:
                    ans[0][i]=ans[1][i]=1
                    upper-=1
                    lower-=1
                else:
                    return []
            elif x==1:
                if upper or lower:
                    if upper>lower:
                        ans[0][i]=1
                        upper-=1
                    else:
                        ans[1][i]=1
                        lower-=1
                else:
                    return []
        return [] if upper or lower else ans