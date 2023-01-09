class Solution:
    def findKthPositive(self, arr: List[int], k: int) -> int:
        #  因为是正整数数组，如果索引i 的数为i+1，则没有少；否则就知道少了几个；
        #  不断二分，找到k
        l, r = 0, len(arr)-1
        while l <= r:
            m = (l + r) // 2
            s = arr[m]-m-1  # 少了s个数
            if s >= k:
                r = m - 1
            else:
                l = m + 1
        if l<len(arr) and arr[l]-l-1 == k:
            return arr[l]-1
        else:
            s = arr[r]-l
            return arr[r] + k-s