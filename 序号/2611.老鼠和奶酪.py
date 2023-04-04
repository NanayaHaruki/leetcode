class Solution:
    def miceAndCheese(self, reward1: List[int], reward2: List[int], k: int) -> int:
        n = len(reward1)
        # 1号能在n中选k个，要让总值最大，判断出哪些奶酪让1号吃更好，计算出差值
        l=[]
        for i in range(n):
            diff = reward1[i]-reward2[i]
            l.append([diff,reward1[i],reward2[i]])
        l.sort(reverse=True)
        ans=0
        for i in range(k):
            ans+=l[i][1]
        for i in range(k,n):
            ans+=l[i][2]
        return ans