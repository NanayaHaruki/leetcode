class Solution:
    def findMaxK(self, nums: List[int]) -> int:
        st=set()
        ans=-1
        for x in nums:
            if -x in st: 
                ans=max(ans,x if x>0 else -x)
            st.add(x)
        return ans