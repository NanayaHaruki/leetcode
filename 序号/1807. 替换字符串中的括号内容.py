class Solution:
    def evaluate(self, s: str, knowledge: List[List[str]]) -> str:
        d=defaultdict(lambda:'?')
        for k,v in knowledge:
            d[k]=v
        f=False
        ans,key='',''
        for x in s:
            if x=='(':
                f=True
            elif x==')':
                ans+=d[key]
                key=''
                f=False
            else :
                if f:
                    key+=x
                else:
                    ans+=x
        return ans