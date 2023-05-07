class Solution:
    def numPairsDivisibleBy60(self, time: List[int]) -> int:
        cnt=[0]*60
        ans=0
        for t in time:
            x=t%60 # 当前数的模
            y=(60-x)%60 # 需要另一个数的模
            ans+=cnt[y]
            cnt[x]+=1
        return ans


        # 取出取值范围内60的倍数，遍历时找 和 能组成倍数的数之前出现过几次
        # target = [60*i for i in range(1,17)]
        # ans=0
        # s={}
        # for x in time:
        #     idx=bisect.bisect_right(target,x)
        #     for t in target[idx:]:
        #         want=t-x
        #         if want<=0:continue
        #         if want in s:
        #             ans+=s[want]
        #     if x in s:
        #         s[x]+=1
        #     else:
        #         s[x]=1
        # return ans