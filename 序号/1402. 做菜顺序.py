class Solution:
    def maxSatisfaction(self, satisfaction: List[int]) -> int:
        # 最大的必然最后选，如果选1个，就是 1*sa[-1];选2个，就是 2*sa[-1]+1*sa[-2],选2个可以由sa[-1] dp得到
        satisfaction.sort()
        ans=ps=0
        for i in range(len(satisfaction)-1,-1,-1):
            x=satisfaction[i]
            ps+=x
            if ps<0:break
            ans+=ps
        return ans