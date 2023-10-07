class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        ans=[0]*len(temperatures)
        st=[]
        for i,t in enumerate(temperatures):
            while st and t>temperatures[st[-1]]:
                # 栈里元素找到答案了
                j=st.pop()
                ans[j]=i-j
            st.append(i)
        return ans