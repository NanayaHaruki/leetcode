class Solution:
    def minimumSize(self, nums: List[int], maxOperations: int) -> int:
        '''
        最多操作maxOperations，每次操作可将袋子里的球放入两个新袋子，求每个袋子球的最大值最小化。
        '''
        # 最小最大问题用二分，返回答案应该是1和最大值之间，二分查找可能的解，判断是否符合maxOperations的要求
        # 对于可能解x， 若nums[i]<=x ,不需要操作； nums[i]<=2x,操作1次；nums[i]<=3x,操作2次，3x第一次分成2x和x，第2次将2x分成x和x即可。。。
        l ,r = 1,max(nums)
        ans=0
        while l <= r:
            target = l+(r-l)//2
            op=0
            for i in nums:
                op+=((i-1)//target)
                if op > maxOperations:
                    break
            if(op <= maxOperations): # 符合要求的情况，尽量让target更小
                ans=target
                r=target-1
            else :
                l=target+1
        return ans