class Solution:
    def maxTotalFruits(self, fruits: List[List[int]], startPos: int, k: int) -> int:
        # 一直往左走能达到的区间是[startPos-k,startPos]
        # 往右走x格，区间范围是[min(startPos,startPos-k+2x),startPos+x]
        # 每往右走一格，左边就会缩2格，注意startPos-k+2x 可能不能返回startPos时，左区间为startPos
        n = len(fruits)
        preSum = ans = 0
        for f in fruits:
            f.append(preSum)
            preSum += f[1]  # f 长度为3，分别表示水果所在位置索引 水果数量  这个位置前有多少水果
        for x in range(k + 1):  # x表示往右走几格
            l = startPos - k + 2 * x
            if l < 0:
                l = 0
            elif l > startPos:
                l = startPos
            r = startPos + x
            i, j = bisect.bisect_left(fruits, [l]), bisect.bisect_left(fruits, [r+1])
            if i==n:
                i=fruits[-1][2]+fruits[-1][1]
            else:
                i=fruits[i][2]
            if j==n:
                j=fruits[-1][2]+fruits[-1][1]
            else:
                j=fruits[j][2]

            ans = max(ans, j - i)
        for x in range(k+1): # 往左走几格
            l=startPos-x
            if l<0:
                l=0
            r=startPos+k-2*x
            if r<startPos:
                r=startPos
            i, j = bisect.bisect_left(fruits, [l]), bisect.bisect_left(fruits, [r+1])
            if i==n:
                i=fruits[-1][2]+fruits[-1][1]
            else:
                i=fruits[i][2]
            if j==n:
                j=fruits[-1][2]+fruits[-1][1]
            else:
                j=fruits[j][2]
            ans = max(ans, j - i)
        return ans