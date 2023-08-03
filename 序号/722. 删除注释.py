class Solution:
    def removeComments(self, source: List[str]) -> List[str]:
        ans=[]
        isBlock=False
        line=""
        for s in source:
            i,n=0,len(s)
            while i<n:
                if isBlock:
                    if s[i]=='*' and i<n-1 and s[i+1]=='/':
                        i+=2
                        isBlock=False
                    else:
                        i+=1
                    continue
                if s[i]=='/' and i<n-1 and (s[i+1]=='/' or s[i+1]=='*'):
                    if s[i+1]=='/':
                        break
                    elif s[i+1]=='*':
                        i+=2
                        isBlock=True
                        continue
                else:
                    line+=s[i]
                i+=1
            # 一行结束 ,如果在块注释中，line保留
            if not isBlock and line:
                ans.append(line)
                line=""
        return ans