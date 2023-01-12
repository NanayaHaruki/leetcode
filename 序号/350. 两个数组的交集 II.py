class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        nums1.sort()
        nums2.sort()
        m,n=len(nums1),len(nums2)
        i,j=0,0
        ans=[]
        while i<m and j<n:
            if nums1[i]<nums2[j]:
                i+=1
                continue
            if nums1[i]>nums2[j]:
                j+=1
                continue
            ans.append(nums1[i])
            i+=1
            j+=1
        return ans