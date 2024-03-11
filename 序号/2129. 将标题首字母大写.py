class Solution:
    def capitalizeTitle(self, title: str) -> str:
        l = list(title)
        def isLower(c):
            return ord(c)>=97
        def toLower(c):
            if isLower(c):
                return c
            return chr(ord(c)+32)
        def toHigher(c):
            if isLower(c):
                return chr(ord(c)-32)
            return c

        def shift(i):
            if i-spaceIndex==2:
                l[i-1]=toLower(l[i-1])
            elif i-spaceIndex==3:
                l[i-1]=toLower(l[i-1])
                l[i-2]=toLower(l[i-2])
            else:
                l[spaceIndex+1]=toHigher(l[spaceIndex+1])
                for j in range(spaceIndex+2,i):
                    l[j]=toLower(l[j])
        spaceIndex = -1
        for i,x in enumerate(l):
            if x==' ':
                shift(i)
                spaceIndex=i
        shift(len(l))
        return ''.join(l)