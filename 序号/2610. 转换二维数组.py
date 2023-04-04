class Solution:
    def findMatrix(self, nums: List[int]) -> List[List[int]]:
        # 一维转二维，要求行数尽量少，每行不能重复
        c = Counter(nums)
        ans=[]
        while c:
            keys = list(c)
            ans.append(keys)
            for k in keys:
                if c[k]==1:
                    del c[k]
                else:
                    c[k]-=1
        return ans
                

