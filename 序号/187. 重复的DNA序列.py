class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        n=len(s)
        st =set()
        ans=set()
        for i in range(n-9):
            cur=s[i:i+10]
            if cur in st:
                ans.add(cur)
            st.add(cur)
        return list(ans)