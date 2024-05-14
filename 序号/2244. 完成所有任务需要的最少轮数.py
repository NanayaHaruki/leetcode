class Solution:
    def minimumRounds(self, tasks: List[int]) -> int:
        cnts = Counter(tasks)
        ans=0
        for v in cnts.values():
                if v==1:return -1
                if v%3==0:
                    ans+=v//3
                else:
                    ans+=(v//3)+1
        return ans