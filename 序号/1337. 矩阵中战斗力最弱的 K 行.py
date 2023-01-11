class Solution:
    def kWeakestRows(self, mat: List[List[int]], k: int) -> List[int]:
        list = []
        row, col = len(mat), len(mat[0])
        for i in range(row):
            l,r=0,col-1
            while l<=r:
                m=(l+r)//2
                if mat[i][m]:
                    l=m+1
                else:
                    r=m-1
            list.append((i, l))
        list.sort(key=lambda x: x[1])
        return [x for x, _ in list[:k]]