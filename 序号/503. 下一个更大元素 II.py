class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        n = len(nums)
        ans = [-1]*n
        q = []
        for i in range(2*n):
            x = nums[i%n]
            while q and q[-1][0]<x:
                v,j = q.pop()
                ans[j]=x
            q.append((x,i%n))
        return ans  
       
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        n=len(nums)
        q=deque()
        ans=[-1]*n
        for i in range(n*2):
            while q and nums[q[-1]]<nums[i%n]:
                j = q.pop() # 比nums[i]小的前一个数的索引
                ans[j]=nums[i%n]
            q.append(i%n)
        return ans