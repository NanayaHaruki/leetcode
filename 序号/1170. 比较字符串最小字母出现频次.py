class Solution:
    def numSmallerByFrequency(self, queries: List[str], words: List[str]) -> List[int]:
        # 对于每次查询，计算出f[q[i]],再找出Words中大于这个值的数量，需要对Words前缀和
        def find(x):
            x=sorted(x)
            a=x[0]
            j=0
            while j<len(x) and x[j]==a:
                j+=1
            return j
        
        n=len(words)
        cnter=Counter()
        for i,x in enumerate(words):
            cnter[find(x)]+=1       
        l=[] 
        for k,v in cnter.items(): # k 最小字符出现次数  v 有几个words最小字符次数都是这个数
            l.append([k,v])
        l.sort()
        j=0
        for i,x in enumerate(l):
            j+=x[1]
            l[i].append(j)

        for i,q in enumerate(queries):
            f=find(q)
            idx=bisect.bisect_right(l,[f,math.inf,0])
            queries[i]= 0 if idx==len(l) else n-l[idx][2]+l[idx][1]
        return queries