class Solution:
    def areSentencesSimilar(self, sentence1: str, sentence2: str) -> bool:
        w1,w2=sentence1.split(' '),sentence2.split(' ')
        i,j=0,0
        m,n=len(w1),len(w2)
        while i<m and i<n and w1[i]==w2[i]:
            i+=1
        while m-j-1>=0 and n-j-1>=0 and w1[m-j-1]==w2[n-j-1]:
            j+=1
        return (i+j)>=min(m,n)