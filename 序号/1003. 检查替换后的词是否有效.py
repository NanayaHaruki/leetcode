class Solution:
    def isValid(self, s: str) -> bool:
        st=[]
        for c in s:
            if c=='b':
                if not st or st[-1]!='a':
                    return False
                st.append('b')
            elif c=='c':
                if len(st)<2 or st[-1]!='b' or st[-2]!='a':
                    return False
                st.pop()
                st.pop()
            else:
                st.append(c)

        return not st