class Solution:
    def maxResult(self, nums: List[int], k: int) -> int:
        # dp[i]为跳到i时最大得分，dp[i]=nums[i]+max(dp[i-k]..dp[i-1])
        # 滑动窗口最大值用单调栈维护，栈顶就是最大值
        n=len(nums)
        f=[0]*n
        f[0]=nums[0]
        st=deque([0])
        for i in range(1,n):
            # 找窗口的最大值前，先判断下栈顶的在不在[i-k,i-1]区间内
            if st[0]<i-k:
                st.popleft()
            f[i]=nums[i]+f[st[0]]
            while st and f[st[-1]]<=f[i]: # 栈顶是最大的，单调减，将比当前小的弹走
                st.pop()
            st.append(i)
        return f[-1]