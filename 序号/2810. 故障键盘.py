class Solution:
    def finalString(self, s: str) -> str:
        r = True
        q = deque()
        for x in s:
            if x=='i':
                r=not r
            else:
                if r:
                    q.append(x)
                else:
                    q.appendleft(x)
        return ''.join(q if r else reversed(q))