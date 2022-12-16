class Solution:
    
    def minElements(self, nums: List[int], limit: int, goal: int) -> int:
        #添加最少的数字，使数组和=goal，数组所有数字要满足abs〈=limit
        s = sum(nums)
        diff = abs(goal-s)
        ans=(int)(diff/limit)
        if diff%limit>0:
            ans+=1
        return ans