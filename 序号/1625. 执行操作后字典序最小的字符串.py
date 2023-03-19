class Solution:
     def findLexSmallestString(self, s: str, a: int, b: int) -> str:
        vis={s}
        q=deque()
        q.append(s)
        ans=s
        while q:
            top = q.popleft()
            if top<ans:
                 ans=top        
            t1=''.join([str((int(c)+a)%10) if i&1 else c for i,c in enumerate(top)])
            t2=top[-b:]+top[:-b]
            if t1 not in vis:
                q.append(t1)
                vis.add(t1)
            if t2 not in vis:
                q.append(t2)
                vis.add(t2)
        return ans