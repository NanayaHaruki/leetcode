class Solution:
    def checkIfExist(self, arr: List[int]) -> bool:
        s=set()
        for i in arr:
            if i*2 in s or ((not i&1) and i>>1 in s):
                return True
            s.add(i)
        return False