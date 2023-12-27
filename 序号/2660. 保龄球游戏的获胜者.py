class Solution:
    def isWinner(self, player1: List[int], player2: List[int]) -> int:
        def compute(player):
            p=-3
            a=0
            for i,x in enumerate(player):
                if i-p<3:
                    a+=2*x
                else:
                    a+=x
                if x==10:
                    p=i
            return a
        p1,p2=compute(player1),compute(player2)
        if p1==p2:
            return 0
        if p1>p2:
            return 1
        return 2