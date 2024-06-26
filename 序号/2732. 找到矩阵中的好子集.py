class Solution:
    def goodSubsetofBinaryMatrix(self, grid: List[List[int]]) -> List[int]:
        # 选2行，每列和不能超过1
        m,n=len(grid),len(grid[0])
        ns = {}
        for i,row in enumerate(grid):
            k = 0
            for j,x in enumerate(row):
                k = k | x<<j
            if k==0:return [i] 
            if i==0:
                ns[k]=0
                continue
            t = ((1<<n)-1)^k
            subT = t
            while subT:
                if subT in ns:
                    return [ns[subT],i]
                subT=(subT-1)&t
            ns[k]=i
        return []