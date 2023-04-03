class Solution:
    def prevPermOpt1(self, arr: List[int]) -> List[int]:
        # 要接近字典序且最大，就要尽量保持前面最多的数字不动，那么从右往左遍历
        # 从右往左找第一个 arr[i] > arr[i+1] 的，i就是可以和后面交换的位置
        # 因为在找到第一个arr[i] > arr[i+1] 就停下来了，所以[i:]不会有arr[k]>arr[k+1]的k位置，即[i+1,n)非递减
        # 现在需要找在[i+1,n)中找到小于arr[i]中最大的，从n-1 位置开始找满足<arr[i]这个条件的j
        # 因为满足条件的可能会有重复，那么索引较小的会更接近原来的字典序，
        # 比如301 需要用1替换而不是用0替换，103当然比031更接近；
        # 而3011，替换成1031 比1013 更接近原字典序
        n = len(arr)
        ok=False
        for i in range(n-2,-1,-1):
            if arr[i]>arr[i+1]:
                for j in range(n-1,i,-1):
                    if arr[j]<arr[i]  and arr[j]!=arr[j-1]: # i最小到0， j取不到0，放心用j-1
                        arr[i],arr[j]=arr[j],arr[i]
                        ok=True
                        break
                if ok:break
        return arr