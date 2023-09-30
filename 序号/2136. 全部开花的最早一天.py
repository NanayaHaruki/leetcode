class Solution:
    def earliestFullBloom(self, plantTime: List[int], growTime: List[int]) -> int:
        # 播种只能一个个的种，种完所有种子天数是固定的，想开花时间最早，需要将生长时间长的最先播
        for i,x in enumerate(growTime):
            growTime[i]=(x,i)
        growTime.sort(reverse=True)
        ans=p=0
        for grow,idx in growTime:
            p+=plantTime[idx]
            ans=max(ans,p+grow)
        return ans