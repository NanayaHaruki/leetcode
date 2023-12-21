class Solution:
    def maximumSumOfHeights(self, maxHeights: List[int]) -> int:
        # 统计以i为山顶，[0,i]的和，建立单调栈，如果栈顶大于当前maxHeights[i],则弹栈，因为i为顶，左边的都要更小，单调栈维持非递减
        n=len(maxHeights)
        prefix=[0]*n
        suffix=[0]*n
        s=[]
        
        for i,x in enumerate(maxHeights):
            while s and maxHeights[s[-1]]>x:
                s.pop()
            if s:
                prefix[i]=prefix[s[-1]]+(i-s[-1])*x
            else:
                prefix[i]=(i+1)*x
            s.append(i)
        s.clear()
        for i in range(n-1,-1,-1):
            while s and maxHeights[s[-1]]>maxHeights[i]:
                s.pop()
            if s:
                suffix[i]=suffix[s[-1]]+(s[-1]-i)*maxHeights[i]
            else:
                suffix[i]=(n-i)*maxHeights[i]
            s.append(i)
        ans=0
        for i in range(n):
            ans=max(ans,prefix[i]+suffix[i]-maxHeights[i])
        return ans