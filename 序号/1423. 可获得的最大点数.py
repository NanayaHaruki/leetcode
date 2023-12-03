class Solution:
    def maxScore(self, cardPoints: List[int], k: int) -> int:
        
        sm=ans=0
        cardPoints+=cardPoints[:k]
        n=len(cardPoints)
        l,r=n-2*k,n-k-1
        for i in range(l,r+1):
            sm+=cardPoints[i]
        ans=sm
        for i in range(1,k+1):
            r+=1
            sm=sm+cardPoints[r]-cardPoints[l]
            ans=max(ans,sm)
            l+=1
        return ans