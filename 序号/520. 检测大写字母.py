class Solution:
    def detectCapitalUse(self, word: str) -> bool:
        if len(word)==1:return True
        if 'A'<=word[0]<='Z' :
            isUp = 'A'<=word[1]<='Z'
        else:
            if 'A'<=word[1]<='Z':
                return False
            isUp = False
        for i in range(2,len(word)):
            x=word[i]
            if 'Z'>=x>='A' :
                if not isUp:
                    return False
            else:
                if isUp:
                    return False
            
        return True