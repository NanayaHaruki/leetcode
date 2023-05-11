class Solution:
    def queryString(self, s: str, n: int) -> bool:
        #时间44 ms击败42.86%内存16.1 MB击败16.88%
        st=set()
        for i,x in enumerate(s):
            x=int(x)
            if not x:continue
            j=i+1
            st.add(x)       
            while j<len(s):
                x= (x<<1) | int(s[j])
                if x<=n:
                    st.add(x)
                else:
                    break
                j+=1
        return len(st)==n

        # 时间44 ms击败42.86% 内存16.2 MB击败14.29%
        # for i in range(1,n+1):
        #     b=bin(i)[2:]
        #     if len(b)>len(s) or b not in s:
        #         return False
        # return True