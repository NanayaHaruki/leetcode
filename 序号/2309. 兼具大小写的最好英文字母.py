class Solution:
    def greatestLetter(self, s: str) -> str:
        st=set()
        diff=97-65
        ans=0
        for c in s:
            if ord(c)>=97:
                if chr(ord(c)-diff) in st:
                    ans=max(ans,ord(c)-diff)
                else:
                    st.add(c)
            else:
                if chr(ord(c)+diff) in st:
                    ans=max(ans,ord(c))
                else:
                    st.add(c)
        return chr(ans) if ans else ''