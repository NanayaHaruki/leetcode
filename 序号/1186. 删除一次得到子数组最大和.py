class Solution:
    def maximumSum(self, arr: List[int]) -> int:
        n = len(arr)
        f=[[-inf,-inf] for _ in range(n)]
        f[0][0]=arr[0]
        for i in range(1,n):
            f[i][0]=max(f[i-1][0],0)+arr[i]
            f[i][1]=max(f[i-1][1]+arr[i],f[i-1][0])
        return max(max(x) for x in f)