class Solution:
    def minAbsoluteSumDiff(self, nums1: List[int], nums2: List[int]) -> int:
        mod=int(1e9+7)
        ans=0
        sorted=[]
        for i in range(len(nums1)):
            sorted.append(nums1[i])
            ans+=abs(nums1[i]-nums2[i])
        sorted.sort()
        def f(ns,k):
            l,r=-1,len(ns)
            while l+1<r:
                m=(l+r)//2
                if ns[m]==k:return 0
                if ns[m]<k:
                    l=m
                else:
                    r=m
            if l<0:l=0
            if r==len(ns):r-=1
            return min(abs(ns[l]-k),abs(ns[r]-k))
        mx=0
        for i in range(len(nums1)):
            diff1=abs(nums1[i]-nums2[i])
            diff2=f(sorted,nums2[i]) 
            mx=max(mx,diff1-diff2)
        return (ans-mx)%mod