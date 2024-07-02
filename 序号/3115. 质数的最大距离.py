N = 101
primes = [True]*N
st = set()
for i in range(2,N):
    if primes[i]:st.add(i)
    for j in st:
        if i*j>=N:break
        primes[i*j]=False
        if i%j==0:break

class Solution:
    def maximumPrimeDifference(self, nums: List[int]) -> int:
        l,r=0,len(nums)-1
        while nums[l] not in st:
            l+=1
        while nums[r] not in st:
            r-=1
        return r-l