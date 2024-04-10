class Solution:
    def maximumBinaryString(self, binary: str) -> str:
        # 最终结果必然最多只有1个0，但凡有2个0，都可以将1后移组成00 再变成10
        # 找到第1个0的位置i，将后面的1挪到最后，能空出几个0，如果000 那最后变成100，110
        i = -1
        n=len(binary)
        cnts = 0
        for j,x in enumerate(binary):
            if x=='0' and i<0:
              i=j
            if j>i and x=='0':
                cnts+=1
        if i==-1:return binary
        # 有几个cnts就表示能加几个1，110001， i是2，cnts也是2，000-〉100 -〉110，i前面本来就都是1，所以开头有i+cnts个1
        # n-1-i 是i后面有多少个数，cnts是这其中有多少个0
        return '1'*(i+cnts)+'0'+'1'*(n-1-i-cnts)

        # 双指针
        # 10->01 ,1可以往后挪，将原本就有的1往后挪
        # 从前往后看，i位置本来是1的不动，本来是0的，看后面还有没有0，有将[i+1,j-1]中间的1挪到[i+2,j]
        # 01110 -〉00111 就可以变成10111了

        # n=len(binary)
        # s = list(binary)
        # l=r=0
        # while l<n :
        #     if s[l]=='1':
        #         l+=1
        #         continue
        #     # 当前是0，找后面的0
        #     if r<=l:
        #         r=l+1
        #     find=False
        #     while r<n:
        #         if s[r]=='0':
        #             find=True
        #             break
        #         r+=1
        #     if not find:
        #         return ''.join(s)
        #     s[l]='1'
        #     s[l+1]='0'
        #     if r-l>1:
        #         s[r]='1'
        #     l+=1
        # return ''.join(s)
        
