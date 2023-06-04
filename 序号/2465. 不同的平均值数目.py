class Solution:
    def distinctAverages(self, nums: List[int]) -> int:
        nums.sort()
        l,r=0,len(nums)-1
        st=set()
        while l<r:
            st.add(nums[l]+nums[r])
            l+=1
            r-=1
        return len(st)
