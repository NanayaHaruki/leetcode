class Solution:
    def smallestBeautifulString(self, s: str, k: int) -> str:
        # 最小字典序，先从最后加1，该进位进。 不进位，往前检查2个位置有无回文，没有再回头检查后面有无回文
        k+=97
        n = len(s)
        s = list(map(ord,s))
        i = n-1
        s[i]+=1
        while i<n:
            if s[i]==k: # 进位
                if i==0:return ''
                s[i]=97
                i-=1
                s[i]+=1
            elif (i>0 and s[i]==s[i-1]) or (i>1 and s[i]==s[i-2]):  # 不进位，往前检查回文
                s[i]+=1 # 有回文，继续涨
            else: # 前面没回文了，往后找
                i+=1
        return ''.join(map(chr,s))