class Solution:
    def minimumOperations(self, nums: List[int]) -> int:
        n=len(nums)
        d=Counter()
    
        for i in range(0,n,2):
            d[nums[i]]+=1
        oddPreCnt=oddMaxNum=oddMaxCnt=0
        for k,v in d.items():
            if v>oddMaxCnt:
                oddPreCnt=oddMaxCnt
                oddMaxNum=k
                oddMaxCnt=v
            elif v>oddPreCnt:
                oddPreCnt=v
       
        d.clear()
        evenPreCnt=evenMaxNum=evenMaxCnt=0
        for i in range(1,n,2):
            d[nums[i]]+=1
       
        for k,v in d.items():
            if v>evenMaxCnt:
                evenPreCnt=evenMaxCnt
                evenMaxCnt=v
                evenMaxNum=k
            elif v>evenPreCnt:
                evenPreCnt=v
        if evenMaxNum!=oddMaxNum:
            return n-evenMaxCnt-oddMaxCnt
        return min(n-evenPreCnt-oddMaxCnt,n-evenMaxCnt-oddPreCnt)