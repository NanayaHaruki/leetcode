class Solution:
    def isCircularSentence(self, sentence: str) -> bool:
        words=sentence.split(' ')
        fw=words[-1]
        for x in words:
            if x[0]!=fw[-1]:
                return False
            fw=x
        return True