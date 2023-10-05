class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        preNotHave,have,notHave=0,-inf,0 # a,b,c表示两天前不持有、1天前持有、1天前不持有
        for x in prices:
            tmpHave = notHave
            notHave=max(notHave,have+x)     
            have = max(have,preNotHave-x)
            preNotHave=tmpHave
        return notHave