class Solution:
    def mostCompetitive(self, nums: List[int], k: int) -> List[int]:
        # 字典序尽量小，单调栈遇到小的就弹出原来大的，能弹几个受到k和nums剩余数字的限制
        st = []
        n=len(nums)
        delCnt = n-k # 最多 删几个
        for i,x in enumerate(nums):
            while st and delCnt and st[-1]>x:
                st.pop()
                delCnt-=1
            st.append(x)
        return st[:k]