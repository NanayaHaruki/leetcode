class Solution:
    def numMovesStones(self, a: int, b: int, c: int) -> List[int]:
        # 每次移动两边到中间，次数最多是只移动一格，次数最少是移动到中间
        # 次数最多，找出中间的数，再找出间隔较大的区间，一格格的走步数最多
        mn=min(a,b)
        if mn==a:
            if a<c<b:
                mid,mx=c,b
            elif c<a:
                mn,mid,mx=c,a,b
            else:
                mid,mx=b,c
        else:
            # b<a
            if b<c<a:
                mid,mx=c,a
            elif c<b:
                mn,mid,mx=c,b,a
            else:
                # a<c
                mid,mx=a,c
        # 求出两段间隔
        # 最少次数：都没间隔就不用移;最多移2次，将两边移到中间即可
        d1,d2=mid-mn-1,mx-mid-1
        if d1==0 and d2==0:
            mnSteps=0
        elif d1<2 or d2<2: # 只要有1个间隔是0，将另一个移过来就行; 间隔是1，将另一个插到中间即可
            mnSteps=1
        else:
            mnSteps=2
        # 最多次数，一格一格的移
        mxSteps=max(mx-mn-2,0)
        return [mnSteps,mxSteps]