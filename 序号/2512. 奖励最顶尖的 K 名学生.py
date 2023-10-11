class Solution:
    def topStudents(self, positive_feedback: List[str], negative_feedback: List[str], report: List[str], student_id: List[int], k: int) -> List[int]:
        po_words,ne_words=set(positive_feedback),set(negative_feedback)
        q=[]
        for i in range(len(report)):
            wl=report[i].split(' ')
            score = 0
            for w in wl:
                if w in po_words:score+=3
                elif w in ne_words:score-=1
            sid=student_id[i]
            heapq.heappush(q,(-score,sid))
        ans=[]
        for i in range(k):
            ans.append(heapq.heappop(q)[1])
        return ans