from typing import List
from collections import Counter


class Solution:
    def maxScoreWords(self, words: List[str], letters: List[str], score: List[int]) -> int:
        # 统计每个字符有几个
        charCnter = Counter(letters)
        wordScore = Counter()
        for x in letters:
            charCnter[x]+=1
        # 统计单词分值，但不能从高到低使用，可能出现oxoxox 4分 但一个ox2分总共能到6分的情况
        
        idx2charCnts = []
        for word in words:
            s = 0
            wordChars = Counter()
            for c in word:
                wordChars[c]+=1
                s+=score[ord(c)-ord('a')]
            wordScore[word]=s
            idx2charCnts.append(wordChars)
            
        mx=0
        def dfs(curScore):
            for i in range(len(words)):
                wordChars=idx2charCnts[i]
                # 判断能不能加这个单词
                canAdd = True
                for c,cnt in wordChars.items():
                    if charCnter[c]<cnt:
                        canAdd=False
                        break
                # 不能加
                if not canAdd:
                    continue
                # 加，选择
                for c,cnt in wordChars.items():
                    charCnter[c]-=cnt
                dfs(curScore+wordScore[words[i]])
                # 撤销选择
                for c,cnt in wordChars.items():
                    charCnter[c]+=cnt
            mx=max(mx,curScore)
        dfs(0)
        return mx
    

words = ["dog","cat","dad","good"]
letters = ["a","a","c","d","d","d","g","o","o"]
score = [1,0,9,5,0,0,3,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0]
i = Solution().maxScoreWords(words,letters,score)
print(i)




        



