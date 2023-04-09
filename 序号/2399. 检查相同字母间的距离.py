class Solution:
    def checkDistances(self, s: str, distance: List[int]) -> bool:
        # 遍历s，当某个字母出现第二次的时候，比对中间的字母数量是否为distance要求的那样
        m = [-1]*26 # 记录第一次出现的索引
        for i,c in enumerate(s):
            idx = ord(c)-ord('a')
            if m[idx]==-1:
                m[idx]=i
            else:
                if distance[idx]!=i-m[idx]-1:
                    return False
        return True
