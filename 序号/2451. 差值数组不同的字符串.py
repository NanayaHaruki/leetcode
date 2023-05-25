class Solution:
    def oddString(self, words: List[str]) -> str:
        # 求出差值数组，原数组长度》=3，前3个可以确定差值数组。第1或第2个是错的会无法确定正确的差值是什么
        n,m=len(words),len(words[0])
        arr0,arr1,arr2=[],[],[]
        
        for j in range(1,m):
            arr0.append(ord(words[0][j])-ord(words[0][j-1]))
            arr1.append(ord(words[1][j])-ord(words[1][j-1]))
            arr2.append(ord(words[2][j])-ord(words[2][j-1]))
        
        if arr0==arr1:
            if arr0!=arr2:
                return words[2] # 0 1 都对;2 不对
        else:
            if arr0==arr2:
                return words[1] # 0 2 对;1不对
            else:
                arr0=arr1
                return words[0] # 0不对，1 2对
        # 后面的与0做对比
        for i in range(3,n):
            for j in range(1,m):
                diff=ord(words[i][j])-ord(words[i][j-1])
                if diff!=arr0[j-1]:
                    return words[i]
        return ""