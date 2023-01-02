class Solution:
    def minMovesToSeat(self, seats: List[int], students: List[int]) -> int:
        '''贪心不行  座位数与学生数相同，得按顺序座，移动数才小'''
        seats.sort()
        students.sort()
        ans=0
        for i in range(len(seats)):
            ans+=abs(students[i]-seats[i])
        return ans