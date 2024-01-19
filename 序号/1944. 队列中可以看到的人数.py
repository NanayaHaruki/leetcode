class Solution:
    def canSeePersonsCount(self, heights: [int]) -> List[int]:
        # 单调栈 弹出前面比cur矮的，被弹的能看到的人数，就是自己和cur索引差
        st=[]
        n=len(heights)
        ans=[0]*n
        for i,h in enumerate(heights):
            while st and heights[st[-1]]<h:
                ans[st.pop()]+=1
            if st:
                ans[st[-1]]+=1
            st.append(i)
        return ans