class Solution:
    def minNumberOfHours(self, initialEnergy: int, initialExperience: int, energy: List[int], experience: List[int]) -> int:
        n = len(experience)
        x,y=initialEnergy,initialExperience
        ans = 0
        for i in range(n):
            a,b=energy[i],experience[i] # 能量减少，经验增加
            if x<=a:              
                ans+=(a-x+1)
                x=a+1
            if y<=b:              
                ans+=(b-y+1)
                y=b+1
            x-=a
            y+=b
        return ans