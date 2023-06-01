class Solution:
    def maximumTastiness(self, price: List[int], k: int) -> int:
        price.sort()
        n=len(price)
        mn,mx=price[0],price[-1]
        mxAns=(mx-mn)//(k-1) # 最好是平均分开，有一个间隔小了，另一个大了没用，因为取绝对值最小
        # 在[0,mxAns]二分检查可行性
        l,r=-1,mxAns+1
        while l+1<r:
            m=(l+r)//2
            #print(f'{l} {r} {m}')
            cnt=1
            cur=mn
            ok=True
            while cnt<k and cur<=mx:
                cur+=m # 目标间隔是m，每次递增至少是m
                idx=bisect.bisect_left(price,cur) 
                if idx==n:
                    ok=False
                    break
                cur=price[idx]
                cnt+=1
            if cnt!=k:
                ok=False
            print(ok)
            if ok:
                l=m
            else:
                r=m
        return l