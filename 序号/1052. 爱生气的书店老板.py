class Solution:
    def maxSatisfied(self, customers: List[int], grumpy: List[int], minutes: int) -> int:
        # 找grumpy[i]==0时，customoers[i]的和，可以将grumpy中某段长为minutes的区间都为0
        # 用长度为minutes的滑动窗口滑着找最大和，被滑动窗口分割成的前后2段用前缀和
        n = len(customers)
        pre = 0
        for i in range(n):
            if i<minutes:
                pre+=customers[i]
            else:
                if grumpy[i]==0:
                    pre+=customers[i]
        ans=pre
        for i in range(minutes,n):
            if grumpy[i-minutes]==1:# 因在窗口内而不生气的，因为窗口走了，现在生气了
                pre-=customers[i-minutes]
            if grumpy[i]==1: # 本来在生气，不满意的客人，滑动窗口路过了，现在不生气了
                pre+=customers[i]
            print(pre)
            ans=max(ans,pre)
        return ans