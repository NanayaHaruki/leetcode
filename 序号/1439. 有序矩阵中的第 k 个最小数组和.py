class Solution:
    def kthSmallest(self, mat: List[List[int]], k: int) -> int:
        m,n=len(mat),len(mat[0])
        sum=[0]
        for row in mat:
            l=[]
            for x in row:
                for y in sum:
                    l.append(x+y)
            l.sort()
            sum=l[:k]
        return sum[-1]


                