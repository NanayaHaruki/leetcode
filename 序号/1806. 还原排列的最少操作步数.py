class Solution:
    def reinitializePermutation(self, n: int) -> int:
        # 原数组前半段变成新数组的偶数索引，后半段变成新数组的奇数索引
        # 前半段数字在新索引会不断*2，直到变成后半段，进入奇数索引。检查多久会回到原来位置
        steps,i=0,1
        while True:
            steps+=1
            if i<n/2:
                i*=2
            else:
                i=(i-n/2)*2+1
            if i==1:
                return steps