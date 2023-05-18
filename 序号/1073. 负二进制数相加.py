class Solution:
    def addNegabinary(self, arr1: List[int], arr2: List[int]) -> List[int]:
        # 第i位为1，表达（-2）^i , （-2）^i +（-2）^i = - (-2)^(i+1), 所以进位要进-1
        # 若第i位为-1， 当前位是几，表达有几个(-2)^i, (-2)^(i+1)=-(-2)^i-(-2)^i,  -(-2)^i=(-2)^(i+1)+(-2)^i
        #    即当前位为-1，则变更为1，再进位1
        if len(arr1)>len(arr2):
            arr1,arr2=arr2,arr1
        i, j = len(arr1)-1, len(arr2)-1
        ans=[]
        c=0
        while i>=0 or j>=0 or c!=0:
            a,b=arr1[i] if i>=0 else 0,arr2[j] if j>=0 else 0
            x=a+b+c
            if x>1:
                ans.append(x-2)
                c=-1
            elif x==-1:
                ans.append(1)
                c=1
            else:
                ans.append(x)
                c=0
            i-=1;j-=1
        while len(ans)>1 and ans[-1]==0:
            ans.pop()
        return ans[::-1]