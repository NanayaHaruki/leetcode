class Solution:
    def minimumRemoval(self, beans: List[int]) -> int:
        # 将所有袋子里的豆子都降到最小袋子数目
        # 将最小袋子拿空，将其他袋子降到第二小的袋子
        # ... 不能全部拿空

        beans.sort()
        n=len(beans)
        mxLeft=0
        for i,x in enumerate(beans):
            # [0,i-1] 全部拿走，[i,n) 拿到x
            left=(n-i)*x # 剩余越多拿的越少
            mxLeft=max(mxLeft,left)
        return sum(beans)-mxLeft


        # sm=sum(beans)
        # n=len(beans)
        # c=Counter()
        # for i,x in enumerate(beans):
        #     c[x]+=1
        # ans=int(1e10)
        # preBagCnt=0 # 累计拿走多少豆子和多少袋子
        # sortedBeans=sorted(c)
        # for i in range(len(sortedBeans)):
        #     beanCnt=sortedBeans[i]
        #     bagCnt=c[beanCnt]     
        #     ans=min(ans,sm-(n-preBagCnt)*beanCnt)
        #     preBagCnt+=bagCnt
        # return ans