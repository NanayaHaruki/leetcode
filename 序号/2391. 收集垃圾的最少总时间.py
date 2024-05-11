class Solution:
    def garbageCollection(self, garbage: List[str], travel: List[int]) -> int:
        n=len(garbage)
        cnts=[-1,-1,-1] # 记录最后一次出现垃圾的位置
        for i,x in enumerate('MPG'):
            for j in range(n-1,-1,-1):
                if x in garbage[j]:
                    cnts[i]=j
                    break


        ans=0
        for i,x in enumerate(garbage):
            ans+=len(x)
            if i<cnts[0]:
                ans+=travel[i]
            if i<cnts[1]:
                ans+=travel[i]
            if i<cnts[2]:
                ans+=travel[i]
        return ans