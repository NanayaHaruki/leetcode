class Solution:
    def canSortArray(self, nums: List[int]) -> bool:
        n = len(nums)
        pc = -1
        l=[]
        for x in nums:
            cur1=str(bin(x)).count('1')
            if cur1==pc:
                l[-1].append(x)
            else:
                l.append([x])
                pc=cur1
        for i in range(1,len(l)):
            if min(l[i])<max(l[i-1]):return False
        return True