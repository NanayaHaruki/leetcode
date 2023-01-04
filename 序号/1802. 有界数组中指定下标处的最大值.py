class Solution:
    def maxValue(self, n: int, index: int, maxSum: int) -> int:
        # nums[index] 最大化，需要让它两边最速降到1，如果与两边的距离为len，则设最大值为 m
        #   len的长度足够让 m 降到 1 ，len>=m-1 , 此时元素和为 （1+m-1）*（m-1)/2 ,（首项+末项）*项数/2 . 再加上1的个数，len-（m-1） ，化简 （m^2-3m）/2+l+1
        #   len的长度不足让 m 降到 1 ，len< m-1 , 元素和为 （m-1+m-1-len+1）*len/2 = （2m-l-1）*l/2

        # 分3种情况
        # 两边都够长
        # maxSum=（m*（m-1）/2+left -（m-1））+（m*（m-1）/2+right -（m-1））+ m

        # 一边够 一边不够，设left不够
        # maxSum = （2*m-left-1）*left/2 +（m*（m-1）/2+right -（m-1））+ m

        # 两边都不够长
        # maxSum= （2*m-left-1）*left/2 + （2*m-right-1)/2 + m    

        # 三个方程都只能m是未知数，解方程即可。两边都够长 m 求出的会比下面两个更大，优先解。
        l,r = index,n-1-index
        if l> r: 
            l,r=r,l
        # 方程1，化简后为 m^2-2m+l+r+2-maxSum=0
        # 判别式
        m=l+1 # 左边够了，两边都够
        sum = m**2-2*m+n+1
        if sum>=maxSum:
            a,b,c = 1,-2,l+r+2-maxSum
            delta = b**2-4*a*c
            if delta>=0:
                return int((-b+ delta**0.5)/(2*a))
        
        # 方程2 ，化简后为 m^2 + （2*l-1）m + (-l*l-l+2r+2-2maxSum)=0

        m=r+1
        sum = (2*(r+1)-l-1)*l/2+m*(m-1)/2+r+1
        if sum >=maxSum:
            a,b,c=1,2*l-1,-l*l-l+2*r+2-2*maxSum
            delta = b**2-4*a*c
            if delta >=0:
                return int((-b+delta**0.5)/(2*a))

        # 方程3
        return int((l**2+l+r**2+r+2*maxSum)/(2*n))