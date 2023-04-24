class Solution:
    def lastSubstring(self, s: str) -> str:
        i,j,k=0,1,0
        while j+k<len(s):
            if s[i+k]==s[j+k]:
                k+=1
                continue
            if s[i+k]<s[j+k]:
                # i~i+k 绝对比j~j+k的字典序小,不用考虑了
                i=i+k+1
                if i>=j:
                    j=i+1
            else:
                # i 那边的比较大, j~j+k 都可以不用考虑了
                j=j+k+1
            # 比出结果了, i j作为起点重新开始比对,作为与起点偏移量的k需要充值为0
            k=0
        return s[i:]
    
      # 利用切片的高效率直接比对
      # return max(s[i:] for i in range(len(s)))