class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        # d={}
        # for i,x in enumerate(numbers):
        #     if target-x in d:
        #         return [d[target-x]+1,i+1]
        #     d[x]=i

        n=len(numbers)
        l,r=0,n-1
        while l<r:
            s=numbers[l]+numbers[r]
            if s==target:
                return [l+1,r+1]
            if s<target:
                l+=1
            else:
                r-=1
        return []