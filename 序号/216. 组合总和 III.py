class Solution:
    def combinationSum3(self, k: int, n: int) -> List[List[int]]:
        # k个数相加和为n， 只能用1-9
        tmp =[]
        ans=[]
        def dfs(i,sm):
            ''' 最小的从i开始，已经选的和为sm '''
            if sm == n:
                if len(tmp)==k:
                    ans.append(tmp[:])
                return False
            elif sm>n:
                return False
            cnts = k-len(tmp) # 还要选cnts个数字
            if i+cnts-1>9: # 坑不够选了
                return False
            if (i+i+cnts-1)*cnts//2+sm>n: # 最小的组合都超了
                return
            for j in range(i,10):
                tmp.append(j)
                ret = dfs(j+1,sm+j)
                tmp.pop()
                if not ret:break
            return True
        dfs(1,0)
        return ans