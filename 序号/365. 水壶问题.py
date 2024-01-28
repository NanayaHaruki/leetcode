class Solution:
    def canMeasureWater(self, x: int, y: int, z: int) -> bool:
        def gcd(a,b):
            return b if a%b==0 else gcd(b,a%b)
        # 每次操作都会清空或倒满桶，所以每次操作两个桶的总量都是x或y。两个桶都有水互相倒，总量不变
        # 经过a次对小桶的操作和b次对大桶的操作后，总量为ax+by=z
        # 裴蜀定理可知：对任意的x，y，有任意的a，b使z一定为(a,b)的最大公约数的倍数
        return x+y>=z and z%gcd(x,y)==0