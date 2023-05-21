class Solution:
    def storeWater(self, bucket: List[int], vat: List[int]) -> int:
        # 需要蓄水k次，要达到条件，计算桶容量扩大到 ceil(v/k)需要的操作次数 
        # 蓄水次数不会超过水缸最大值
        mx=max(vat)
        if not mx:
            return 0
        n=len(bucket)
        ans=math.inf
        for k in range(1,mx+1):
            sumOps=0
            for i in range(n):
                b,v=bucket[i],vat[i]
                sumOps+=max(0,math.ceil(v/k)-b)
            ans=min(ans,k+sumOps)
        return ans