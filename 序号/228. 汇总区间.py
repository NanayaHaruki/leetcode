class Solution:
    def summaryRanges(self, nums: List[int]) -> List[str]:
        start=pre=0
        n=len(nums)
        ans=[]
        if n==1:
            ans.append(str(nums[0]))
            return ans
        for i,x in enumerate(nums):
            if i==0:
                start=pre=x
            elif i==n-1:
                if x==pre+1:
                    ans.append(f'{start}->{x}')
                else:
                    if start==pre:
                        ans.append(str(start))
                    else:
                        ans.append(f'{start}->{pre}')
                    ans.append(str(x))
            else:
                if x==pre+1:
                    pre=x
                else:
                    if start==pre:
                        ans.append(str(pre))
                    else:
                        ans.append(f'{start}->{pre}')
                    start=pre=x   
        return ans