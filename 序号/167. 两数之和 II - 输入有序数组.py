class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        # 找和为target的两个数
        # 方法一，从左到右遍历，固定一个数，二分找另一个数；nlogN
        # for i,x in enumerate(numbers):
        #     y = target-x
        #     j=bisect.bisect_left(numbers,y,i+1)
        #     if j==len(numbers) or numbers[j]!=y:
        #         continue
        #     else :
        #         return [i+1,j+1]

        # 方法二 遍历到i时，在字典中找有没有另一个数
        d={}
        for i,x in enumerate(numbers):
            if target-x in d:
                return [d[target-x]+1,i+1]
            d[x]=i