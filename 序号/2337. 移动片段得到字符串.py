class Solution:
    def canChange(self, start: str, target: str) -> bool:
        n = len(start)
        i = j = 0
        while i < n and j < n:
            while i < n and start[i] == "_":
                i += 1
            while j < n and target[j] == "_":
                j += 1
            if i < n and j < n:
                a, b = start[i], target[j]
                if a != b:
                    return False
                if (a == "L" and i < j) or (a == "R" and i > j):
                    return False
                i, j = i + 1, j + 1
        # 有没走完的，如果都是_ 也可以
        while i < n and start[i] == "_":
            i += 1
        if i < n:
            return False
        while j < n and target[j] == "_":
            j += 1
        if j < n:
            return False
        return True