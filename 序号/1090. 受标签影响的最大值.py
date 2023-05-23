class Solution:
    def largestValsFromLabels(
        self, values: List[int], labels: List[int], numWanted: int, useLimit: int
    ) -> int:
        # 限定了相同标签的个数，按标签分类，每类中找最大的useLimit个
        d= {}
        for value,label in zip(values,labels):
            if label in d:
                bisect.insort(d[label],value)
            else:
                d[label]=[value]
        candidate=[]
        for vs in d.values():
            if len(vs)<=useLimit:
                candidate.extend(vs)
            else:
                candidate.extend(vs[-useLimit:])
        candidate.sort()
        return sum(candidate[-numWanted:])