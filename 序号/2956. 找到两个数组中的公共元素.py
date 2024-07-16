class Solution:
    def findIntersectionValues(self, nums1: List[int], nums2: List[int]) -> List[int]:
        s1,s2=Counter(nums1),Counter(nums2)
        ans = [0,0]
        for x in s1:
            if x in s2:
                ans[0]+=s1[x]
        for x in s2:
            if x in s1:
                ans[1]+=s2[x]
        return ans