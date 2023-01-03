class Solution:
    def areNumbersAscending(self, s: str) -> bool:
        arr = s.split(" ")
        pre = 0
        for str in arr:
            c = str[0]
            if ord(c) - ord("0") < 10:
                if int(str) <= pre:
                    return False
                else:
                    pre = int(str)
        return True