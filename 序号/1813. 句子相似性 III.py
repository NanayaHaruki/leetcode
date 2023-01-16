class Solution:
    def areSentencesSimilar(self, sentence1: str, sentence2: str) -> bool:
        words1, words2 = sentence1.split(" "), sentence2.split(" ")
        if len(words1)>len(words2):
            words1,words2=words2,words1
        for i in range(len(words1)+1):  # words1 前i个单词在words2的首部，其余在尾部
            f = True
            for j in range(len(words1)):
                if j < i:
                    if words1[j] == words2[j]:
                        continue
                    else:
                        f = False
                        break
                else:
                    if words1[j - len(words1)] == words2[j - len(words1)]:
                        continue
                    else:
                        f = False
                        break
            if f:
                return True
        return False