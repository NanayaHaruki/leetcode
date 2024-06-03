class Solution:
    def distributeCandies(self, candies: int, n: int) -> List[int]:
       
        ans=[0]*n
        def c(x):
            return (x+x+n-1)*n//2
        fst = 1
        sm = c(fst)
        loop=0
        while candies>=sm:
            candies-=sm
            fst+=n
            sm=c(fst)
            loop+=1
        for i in range(n):
            ans[i]=(i+1)*loop+n*loop*(loop-1)//2
            x=fst+i
            if candies>=x:
                ans[i]+=x
                candies-=x
            else:
                ans[i]+=candies
                candies=0
        return ans