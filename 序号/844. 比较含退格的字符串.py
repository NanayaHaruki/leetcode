class Solution:
    def backspaceCompare(self, s: str, t: str) -> bool:
        def a(l,ss)->int:
            p = 0
            for x in ss:
                if x != "#":
                    l[p] = x
                    p += 1
                else:
                    if p:
                        p -= 1
            return p
        ls,lt=['a']*len(s),['a']*len(t)
        pa,pb=a(ls,s),a(lt,t)
        if pa!=pb:
            return False
        for i in range(pa):
            if ls[i]!=lt[i]:
                return False
        return True