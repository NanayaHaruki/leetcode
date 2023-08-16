class Solution:
    def circularGameLosers(self, n: int, k: int) -> List[int]:
        vis=set()
        i = p = 1

        while True:
            if p in vis:
                break
            vis.add(p)
            p=(p+i*k)%n
            if p==0:p=n
            i+=1
        ans=[]
        for i in range(1,n+1):
            if i not in vis:
                ans.append(i)
        return ans