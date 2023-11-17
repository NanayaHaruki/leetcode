class Solution:
    def maximumSumQueries(self, nums1: List[int], nums2: List[int], queries: List[List[int]]) -> List[int]:
        '''
        对于queries[i]的xi,yi  在nums1和nums2中找一个索引 j 使 nums[1]>=xi && nums[j]>=xi 且 nums1[j]+nums2[j] 最大
        '''
        # 比如 [(4,1),(4,2) ,(2,7)]，找到了 满足 （4，1）的答案，
        ans=[-1]*len(queries)
        q=sorted(enumerate(queries),key=lambda x:-x[1][0]) # 保留索引，根据第一个元素从大到小排序
        ns=sorted(((x,y) for x,y in zip(nums1,nums2)),key=lambda x:-x[0])
        j=0
        stack=[] # stack[i] = (y,x+y)
        for i,(qx,qy) in q:         
            while j<len(ns) and ns[j][0]>=qx:
                x,y=ns[j]
                sm=x+y
                while stack and stack[-1][1]<=sm: # 前面的元素 x必定更大，如果和小了说明y小了，那么当前这个 y更大，x+y更大的会是更优先的答案。（ 上面的while保证了虽然 x 小了，但依然满足查询条件）
                    stack.pop()
                if not stack or y>stack[-1][0]:
                    stack.append((y,sm))
                j+=1
            # 符合条件大于x的答案都在stack里了，而x+y是升序的，只要找到满足>=y的答案即可，二分咯
            idx = bisect.bisect_left(stack,(qy,0))
            if idx < len(stack):
                ans[i]=stack[idx][1]
        return ans