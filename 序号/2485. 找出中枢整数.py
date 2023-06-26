class Solution:
    def pivotInteger(self, n: int) -> int:
        # 存在m （1+m）*m=(m+n)*(n-m+1)
        m = int(((n**2+n)//2)**0.5)
        return m if m*(1+m)==(m+n)*(n-m+1) else -1