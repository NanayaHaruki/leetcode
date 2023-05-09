class Solution:
    def countTime(self, time: str) -> int:
        i,ans=0,1
        while i<5:
            if time[i]=='?':
                if i==0:
                    if time[1]!='?' :
                        if time[1]<'4':
                            ans*=3
                        else:
                            ans*=2
                    else:
                        ans*=24
                    i=3
                elif i==1: # 第一位直接跳
                    if time[0]=='2':
                        ans*=4
                    else:
                        ans*=10
                    i=3
                elif i==3:
                    ans*=6
                    i+=1
                else:
                    ans*=10
                    i+=1
            else:
                i+=1
        return ans