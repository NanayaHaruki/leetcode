class Solution:
    def isValidSerialization(self, preorder: str) -> bool:
        nodes = preorder.split(',')
        cnt = 1
        for i,node in enumerate(nodes):
            if node == '#':
                if cnt>0:
                    cnt-=1
                    if cnt==0 and i!=len(nodes)-1:
                        return False
                else:
                    return False
            else:
                cnt+=1
        return cnt==0