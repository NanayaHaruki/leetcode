class Solution:
    def decodeString(self, s: str) -> str:
        # stack
        res,repeat,stack='',0,[]
        for c in s:
            if c=='[':
                stack.append((res,repeat))
                res,repeat='',0
            elif c==']':
                preRes,preRepeat=stack.pop()
                res=preRes+preRepeat*res
            elif '0'<=c<='9':
                repeat=repeat*10+int(c)
            else:
                res+=c
        return res

        # def dfs(s,start):
        #     end=len(s)
        #     i,res,repeat=start,'',0
            
        #     while i<end:
        #         c=s[i]
        #         if c==']':
        #             return i,res
        #         elif c=='[':
        #             j,tmp=dfs(s,i+1)
        #             res+=tmp*repeat
        #             i=j+1
        #             repeat=0
        #         elif '0'<=c<='9':
        #             repeat=repeat*10+int(c)
        #             i+=1
        #         else:
        #             res+=s[i]
        #             i+=1
        #     return i,res
        # return dfs(s,0)[1]