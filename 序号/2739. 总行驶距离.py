class Solution:
    def distanceTraveled(self, mainTank: int, additionalTank: int) -> int:
        # 1L =10 km
        # 讨论主油箱可以加几次油
        # 主油箱有[0,4]加不了
        # [5,8] 加1次
        # [9，12］加2次
        # 可以发现每多4L，就可以多加1次，
        # 但很明显下限是对的5/4=1，9/4=2，但上限 8/4=2，12/4=3不对，所以不能直接除4。
        # 对x 升油可以加 (x-1)/4 就对了。
        # 当然，还要考虑副油箱总共有多少油可以加
        return 10*(mainTank+min(additionalTank,(mainTank-1)//4))
        # simulate
        # ans=0
        # while mainTank:
        #     if mainTank>=5:
        #         if additionalTank:
        #             additionalTank-=1
        #             mainTank-=4
        #         else:
        #             mainTank-=5
        #         ans+=50
        #     else:
        #         ans+=mainTank*10
        #         mainTank=0
        # return ans

