class Solution:
    def minimumMoves(self, nums: List[int], k: int, maxChanges: int) -> int:
        # 可以将任意位置的0变成1 maxchanges次，可以交换相邻的01 无数次
        # 最少操作次数捡起k个1

        # maxChanges 足够大的情况，只要选个位置i，不断将i+1变成1再交换就可以了
        # 连续3个1的，取中间的1，交换两遍的1，2步操作拿到3个1，剩下k-3个通过2步操作拿到
        # 只有2个1的，随便取其中一个，交换另一个，1步操作拿2个，剩k-2个通过2步操作拿到
        # 只有1个1的，剩下k-1个通过2步操作拿到
        start,c= -1,0
        for i,x in enumerate(nums):
            if x :
                if start == -1:
                    start = i
            else:
                if start !=-1:
                    c=max(c,i-start)
                    start = -1
        if start!=-1:c=max(c,len(nums)-start)
        c=min(c,3)
        if c>=k:
            return k-1
        if c==0:
            return -1 if maxChanges<k else k*2
        if maxChanges>=k-c:
            return c-1+2*(k-c)
        # maxChanges不够的情况，将转换全用上，剩下k-maxChange都要通过移动1来获得
        # 统计所有1的位置，找长度为k-maxChanges的子数组的中位数为一开始选的点
        # [1,2,4] 将起点设在2，所有满足条件的子数组中找首尾间隔最小的
        l = [i for i,x in enumerate(nums) if x]
        if len(l)+maxChanges<k:return -1
        c = k - maxChanges
        m = (c-1)//2
        target = l[(c-1)//2]
        s1 = sum(target-l[i] for i in range(m))
        s2 = sum(l[i]-target for i in range(m+1,c))
        if c%2:
            n1=n2=c//2
        else:
            n1,n2=c//2-1,c//2
        s = s1+s2
        for j in range(c,len(l)):
            i = j-c+1
            m = (i+j)//2
            diff = l[m]-l[m-1]
            s1=s1+(n1+1)*diff-(l[m]-l[i-1]) # n1个数需要补差，上个窗口的中点也要补，总共n1+1个
            s2=s2-n2*diff+l[j]-l[m]
            s = min(s,s1+s2)
        return s+2*maxChanges