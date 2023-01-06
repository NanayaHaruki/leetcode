class Solution:
    def nextGreatestLetter(self, letters: List[str], target: str) -> str:
        i = bisect.bisect_right(letters,target)
        if i==len(letters):
            return letters[0]
        else:
            return letters[i]