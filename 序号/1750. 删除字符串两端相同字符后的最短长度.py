class Solution:
    def minimumLength(self, s: str) -> int:
        l,r,k =0, len(s)-1,len(s)
        while l < r:
            lc,rc = s[l],s[r]
            if lc!=rc:
                break
            i,j=l,r
            while i<k and s[i]==lc:
                i+=1
            while j>-1 and s[j]==rc:
                j-=1
            l,r = i,j
        if l < r:
            return r-l+1 # 两边不等没法删了
        elif l == r:
            return 1 # 就剩最后一个了
        else : # 最中间的是相同的字符，两个指针交叉错过了,如果有2个，一头删一个。如果有3个，一头删2个一头删1个。都能全部删掉
            return 0