class Solution:
    def smallestString(self, s: str) -> str:
        chars = list(s)
        f = False # 必须操作一次
        for i,c in enumerate(chars):
            if c!='a':
                chars[i]=chr(ord(c)-1)
                f = True
            else:
                if not f:
                    continue
                else:
                    break
        if not f:
            last = chars[-1]
            if last=='a':
                chars[-1]='z'
            else:
                chars[-1]=chr(ord(chars[-1])-1)
        return ''.join(chars)