class Solution:
    def minSwapsCouples(self, row: List[int]) -> int:
        d={}
        for i,x in enumerate(row):
            d[x]=i
        ans=0
        for i in range(0,len(row),2):
            if row[i]&1:
                if row[i+1]==row[i]-1:
                    continue
                else:
                    idx=d[row[i]-1]# i位置的对象原先的位置
                    d[row[i+1]]=idx
                    row[idx]=row[i+1]
                    ans+=1
                    # d[row[i]-1]=i+1
            else:
                if row[i+1]==row[i]+1:
                    continue
                idx=d[row[i]+1]
                d[row[i+1]]=idx
                row[idx]=row[i+1]
                ans+=1
        return ans
