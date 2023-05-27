class Solution:
    def sampleStats(self, count: List[int]) -> List[float]:
        mn=math.inf
        mx=-math.inf
        sm= modeK=modeV=0 # modeK 出现次数最多的数 modeV modeK出现的次数
        n=0
        
        cnter=defaultdict(int)
        for i,x in enumerate(count):
            if not x:continue
            if i>mx:mx=i
            if i<mn:mn=i
            sm+=i*x
            n+=x
            if x>modeV:
                modeK,modeV=i,x
            cnter[i]=x
        mean=sm/n
        s=sorted(cnter)
        # 中位数 奇数为第(n+1)/2个数  偶数为n//2 n//2=1
        cnt=a=b=median=0
        if n&1:
            for k in s:
                cnt+=cnter[k]
                if cnt>=(n+1)//2:
                    median=k
                    break
        else:
            for k in s:
                cnt+=cnter[k]
                if cnt>=n//2+1:
                    b=k
                    if not a:
                        a=k
                    median=(a+b)/2
                    break
                if cnt>=n//2:
                    a=k
        return [mn,mx,mean,median,modeK]