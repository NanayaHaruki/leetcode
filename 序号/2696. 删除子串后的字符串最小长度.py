class Solution:
    def minLength(self, s: str) -> int:
        st=[]
        for x in s:
            if st and (st[-1]+x=='AB' or st[-1]+x=='CD'):
                st.pop()
            else:
                st.append(x)
        return len(st)