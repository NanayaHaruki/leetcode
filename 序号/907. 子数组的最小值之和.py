class Solution:
    def sumSubarrayMins(self, arr: List[int]) -> int:
        # 贡献法 每个数如果能成为答案的一部分，则该数为所在子数组中最小值，只要找到两遍更小的边界即可计算出该数贡献了几次
        # 单调栈 要找到左边更小的数，只要把更大的数弹出去即可。同时，当一个数被弹出，以为这弹它的是它的右边界，栈下面的是它的左边界
        ans,n,st=0,len(arr),[-1]
        arr.append(-1)
    
        for r,x in enumerate(arr):
            while arr[st[-1]]>x:
                i = st.pop()
                ans+=(i-st[-1])*(r-i)*arr[i]
            st.append(r)
        return ans%(10**9+7)