class Solution:
    def reverseStr(self, s: str, k: int) -> str:
        n = len(s)
        # 0 k-1
        # k 2k-1
        # 2k 3k-1
        # 3k 4k-1
        if k<n:
            s=s[k-1::-1]+s[k:]
        else:
            s=s[::-1]
        i = 2
        while i*k<n:
            if (i+1)*k<n:
                s=s[:i*k]+s[(i+1)*k-1:i*k-1:-1]+s[(i+1)*k:]
            else:
                s=s[:i*k]+s[n:i*k-1:-1]
            i+=2
        return s