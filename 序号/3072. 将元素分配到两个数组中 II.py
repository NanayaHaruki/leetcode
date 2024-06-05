class BIT:
    def __init__(self,n):
        self.n=n
        self.arr = [0]*(n+1)
        self.cache=[]

    def lb(self,x):
        return x&-x
    
    def add(self,x):
        self.cache.append(x)
        while x<=self.n:
            self.arr[x]+=1
            x+=self.lb(x)
    def sum(self,x):
        sm=0
        while x>0:
            sm+=self.arr[x]
            x-=self.lb(x)
        return sm

    def greater(self,x):
        return self.sum(self.n) - self.sum(x)

class Solution:
    def resultArray(self, nums: List[int]) -> List[int]:
        # 离散化,将nums中的数变成1 2 3  方便数状数组储存
        sorted_nums = sorted(nums)
        d1,d2={},{}
        for i,x in enumerate(sorted_nums,1):
            d1[i]=x
            d2[x]=i
        n = len(nums)
        t1,t2 = BIT(n),BIT(n)
        t1.add(d2[nums[0]])
        t2.add(d2[nums[1]])
        for j in range(2,n):
            x = nums[j]
            i = d2[x]
            c1,c2=t1.greater(i),t2.greater(i)
            if c1>c2:
                t1.add(i)
            elif c1<c2:
                t2.add(i)
            else:
                len1,len2 = len(t1.cache),len(t2.cache)
                if len1<=len2:
                    t1.add(i)
                else:
                    t2.add(i)
        return [d1[x] for x in t1.cache+t2.cache]