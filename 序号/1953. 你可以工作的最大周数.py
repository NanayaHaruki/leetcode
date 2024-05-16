class Solution:
    def numberOfWeeks(self, milestones: List[int]) -> int:
        mx,s=max(milestones),sum(milestones)
        return s if mx<(s-mx)+1 else (s-mx)*2+1
        