class Solution:
    def nextBeautifulNumber(self, n: int) -> int:
        def check(x):
            c = Counter(str(x))
            for k,v in c.items():
                if int(k)!=v:return False
            return True
        for i in range(n+1,1224445):
            if check(i):return i
        return -1