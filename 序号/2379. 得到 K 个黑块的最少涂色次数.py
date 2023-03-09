class Solution:
    def minimumRecolors(self, blocks: str, k: int) -> int:
        # 长度为k的黑色，用k作为滑动窗口长度，滑过去统计最小值即可
        cnt=0
        for i in range(k):
            if blocks[i]=='B':
                cnt+=1
        ans=k-cnt
        for i in range(k,len(blocks)):
            if blocks[i]=='B':
                cnt+=1
            if blocks[i-k]=='B':
                cnt-=1
            ans=min(ans,k-cnt)
        return ans
