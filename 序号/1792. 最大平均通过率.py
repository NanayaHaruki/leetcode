class Clz:
    def __init__(self,ps,total):
        self.ps=ps
        self.total = total

    def __lt__(self,other): 
        return (other.total-other.ps)*(self.total+1)*self.total < (self.total-self.ps)*(other.total+1)*other.total


class Solution:
    def maxAverageRatio(self, classes: List[List[int]], extraStudents: int) -> float:
        l=[Clz(*c) for c in classes]
        heapq.heapify(l)

        # 将好学生加进通过增长率最高的班级中，不断更新通过率总和，直到用完所有好学生
        for _ in range(extraStudents):
            heapq.heapreplace(l,Clz(l[0].ps+1,l[0].total+1))
        return sum(clz.ps/clz.total for clz in l) / len(classes)