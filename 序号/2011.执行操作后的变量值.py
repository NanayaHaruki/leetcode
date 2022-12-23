class Solution:
    def finalValueAfterOperations(self, operations: List[str]) -> int:
        i = 0
        for op in operations:
            if op[0]=='+' or op[-1]=='+':
                i+=1
            else:
                i-=1
        return i