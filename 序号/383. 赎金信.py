class Solution:
    def canConstruct(self, ransomNote: str, magazine: str) -> bool:
        cnt=[0]*128
        for x in magazine:
            cnt[ord(x)]+=1
        for x in ransomNote:
            cnt[ord(x)]-=1
            if cnt[ord(x)]<0:
                return False
        return True