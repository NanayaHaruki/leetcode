class Solution:
    def finalPrices(self, prices: List[int]) -> List[int]:
        # 下一个更低的价格，是当前能抵的折扣
        ans=[0]*len(prices)
        st=[]
        for i,x in enumerate(prices):
            while st and x<=prices[st[-1]]:
                j=st.pop()
                ans[j]=prices[j]-x
            st.append(i)
        while st: # 遍历完了，栈内还有的都是无法获得折扣的
            j=st.pop()
            ans[j]=prices[j]
        return ans