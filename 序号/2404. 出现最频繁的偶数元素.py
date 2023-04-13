class Solution:
    def mostFrequentEven(self, nums: List[int]) -> int:
        c=Counter()
        for i in nums:
            if i&1==0:
                c[i]+=1
        t=s=-1
        for num,cnt in c.items():
            if cnt>s or (cnt==s and num<t):
                t,s=num,cnt
        return -1 if s==-1 else t