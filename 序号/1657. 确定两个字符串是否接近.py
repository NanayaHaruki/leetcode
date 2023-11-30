class Solution:
    def closeStrings(self, word1: str, word2: str) -> bool:
        # 可以交换两个字符，说明可以任意排序
        # 可以交换两类字符，说明字符出现次数可以交换
        # 对比两个字符串的字符种类是否一致，再对比字符出现次数是否一致
        if len(word1)!=len(word2):return False

        c1,c2=Counter(word1),Counter(word2)
        k1,k2 = sorted(c1),sorted(c2)
        if len(k1)!=len(k2):return False
        for x,y in zip(k1,k2):
            if x!=y:return False
        v1,v2=sorted(c1.values()),sorted(c2.values())
        for x,y in zip(v1,v2):
            if x!=y:return False
        return True