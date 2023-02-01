class Solution:
    def decodeMessage(self, key: str, message: str) -> str:
        d=['']*26
        st=set()
        for k in key:
            if k==' ':continue
            if k not in st:
                d[ord(k)-ord('a')]=chr(ord('a')+len(st))
                st.add(k)
            if len(st)==26:break
        ans=''
        for c in message:
            if c==' ':
                ans+=c
            else:
                ans+=d[ord(c)-ord('a')]
        return ans