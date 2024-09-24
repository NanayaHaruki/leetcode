class Solution:
    def maximumSubsequenceCount(self, text: str, pattern: str) -> int:
        if pattern[0]==pattern[1]:
            cnt = sum(1 if x==pattern[0] else 0 for x in text)+1
            return cnt*(cnt-1)//2
        la,lb=[],[]
        for i,x in enumerate(text):
            if x==pattern[0]:
                la.append(i)
            elif x==pattern[1]:
                lb.append(i)
        j=0
        ans=0
        for i in range(len(la)):
            while j<len(lb) and lb[j]<la[i]:j+=1
            ans+=len(lb)-j
        return ans+max(len(la),len(lb))
