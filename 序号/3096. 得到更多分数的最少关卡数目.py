class Solution:
    def minimumLevels(self, possible: List[int]) -> int:
        n = len(possible)
        presum = [0]*(n+1)
        total = 0
        for i,x in enumerate(possible):
            if x==0:
                presum[i+1]=presum[i]-1
                total-=1
            else:
                presum[i+1]=1+presum[i]
                total+=1

        for i in range(1,n): # 不能到n，因为a和b都要至少拿一个
            if presum[i]>presum[-1]-presum[i]:
                return i
        return -1