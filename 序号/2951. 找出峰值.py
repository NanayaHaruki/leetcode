class Solution:
    def findPeaks(self, mountain: List[int]) -> List[int]:
        ans=[]
        for i in range(1,len(mountain)-1):
            a,b,c=mountain[i-1],mountain[i],mountain[i+1]
            if b>a and b>c :
                ans.append(i)
        return ans