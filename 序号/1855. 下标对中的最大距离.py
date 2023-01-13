class Solution:
    def maxDistance(self, nums1: List[int], nums2: List[int]) -> int:
        # 二分
        # m,n=len(nums1),len(nums2)
        # for i in range(m):
        #     l,r=i,n-1
        #     while l<=r:
        #         m=(l+r)//2
        #         if nums2[m]>=nums1[i]:
        #             l=m+1
        #         else:
        #             r=m-1
        #     ans=max(ans,r-i)
        # return ans

        # 双指针
        s,f,ans=0,0,0
        n1,n2=len(nums1),len(nums2)
        while s<n1 and f<n2:
            while f<n2 and nums2[f]>=nums1[s]:
                f+=1
            ans=max(ans,f-1-s)
            s+=1
        return ans