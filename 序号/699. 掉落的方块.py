from sortedcontainers import SortedSet
class ODT:
    def __init__(self):
        self.tree = SortedSet()
        self.tree.add((0,inf,0))
        self.mx=0

    def split(self,x):
        t = self.tree
        idx = t.bisect_left((x+1,0,0))-1
      
        if t[idx][0]==x:
            return idx
        l,r,v = t[idx]
        t.pop(idx)
        t.add((l,x,v))
        ans = (x,r,v)
        t.add(ans)
        return idx+1
    
    def add(self,l,r,v):
        r_idx =self.split(r)
        l_idx = self.split(l)
        highest = 0
        cur = l_idx
        while self.tree[cur][0]<r:
            highest=max(highest,self.tree[cur][2])
            self.tree.pop(cur)
        self.tree.add((l,r,highest+v))
        self.mx=max(self.mx,highest+v)
       
        

class Solution:
    def fallingSquares(self, positions: List[List[int]]) -> List[int]:
        n=len(positions)
        ans = []
        odt = ODT()
        for left,size in positions:
            odt.add(left,left+size,size)
            ans.append(odt.mx)
        return ans