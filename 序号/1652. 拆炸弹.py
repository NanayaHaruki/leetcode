class Solution:
    def decrypt(self, code: List[int], k: int) -> List[int]:
        n=len(code)
        code+=code
        prefix = list(accumulate(code))
     
        ans=[0]*n
        # 1 2 3 4 1 2 3 4
        for i in range(n):
            if k<0:
                print(i+n-1,i+n-k-1)
                ans[i] = prefix[i+n-1]-prefix[i+n+k-1]
            elif k>0:
                ans[i]= prefix[i+k]-prefix[i]
            else:
                ans[i]=0
        return ans
