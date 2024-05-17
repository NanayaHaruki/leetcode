# 240517 
class Solution:
    def maxProfitAssignment(self, difficulty: List[int], profit: List[int], worker: List[int]) -> int:
        m,n=len(worker),len(difficulty)
        p = list(zip(difficulty,profit))
        p.sort()
        mxp = [0]*n # mxp[i]为[0,i]范围内的最大利润，通过工人的能力二分得出i，再通过这个数组拿到最大利润的工作
        mxp[0]=p[0][1]
        for i in range(1,n):
            mxp[i]=max(mxp[i-1],p[i][1])
        ans = 0
        for w in worker:
            idx = bisect.bisect_right(p,(w,inf))
            if idx==0:continue
            ans+=mxp[idx-1]
        return ans


class Solution:
    def maxProfitAssignment(self, difficulty: List[int], profit: List[int], worker: List[int]) -> int:
        m,n=len(worker),len(difficulty)
        work=[] 
        for i in range(n):
            work.append((difficulty[i],profit[i]))
        work.sort(key=lambda x:x[0])
        ps=[0]*n
        ps[0]=work[0][1]
        ans=0
        for i in range(1,n):
            ps[i]=max(ps[i-1],work[i][1])
        for w in worker:
            l,r=-1,m
            while l+1<r:
                mid=(l+r)//2
                if work[mid][0]<=w:
                    l=mid
                else :
                    r=mid
            if l>=0:
                ans+=ps[l]
        return ans