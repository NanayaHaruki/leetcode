class Solution:
    def minimumJumps(self, forbidden: List[int], a: int, b: int, x: int) -> int:
        if x==0:return 0
        f = set(forbidden)
        v=set()
        v.add(0)
        q=deque()
        q.append((0,0,0)) # (当前位置，步数，上一步怎么来的用来阻止连续后跳)
        mn,mx=0,max(max(f)+a,x)+b
        while q:
           
            i,step,d=q.popleft()
            print(i)
            l,r=i-b,i+a
            if d==-1: # 左跳来的 下一步必然右跳
                if r==x:return step+1
                if mn<=r<=mx and r not in v and r not in f:
                    q.append((i+a,step+1,1))
                    v.add(r)
            else:
                if l==x or r==x:return step+1
                if mn<=l<=mx and l not in v and l not in f:
                    q.append((i-b,step+1,-1))
                    v.add(-l)
                if mn<=r<=mx and r not in v and r not in f:
                    q.append((i+a,step+1,1))
                    v.add(r)
        return -1