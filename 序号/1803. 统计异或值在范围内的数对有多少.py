class Solution:
    
    class Trie:
        def __init__(self) -> None:
            self.children=[None,None]
            self.cnt=0

    root = Trie()
    max_bit = 14
    def add(self,num):
        cur = self.root
        for i in range(self.max_bit,-1,-1):
            bit = num >>i & 1
            if not cur.children[bit]:
                cur.children[bit]=self.Trie()
            cur.children[bit].cnt+=1
            cur=cur.children[bit]

    def get(self,num,x):
        cur = self.root
        sum=0
        for i in range(self.max_bit,-1,-1):
            bitNum = num >> i & 1
            bitX = x>>i&1
            if bitX: # x当前比特位为1，无论nums和谁比，都要小的。
                if cur.children[bitNum]:  #和nums当前位相同，那么更低位不用比了，全部符合要求。
                    sum+=cur.children[bitNum].cnt
                if cur.children[bitNum ^ 1]: #和nums当前位不同，那么异或之后也为1，需要继续比对
                    cur=cur.children[bitNum^1]
                else :
                    return sum
            else:   # x当前位是0，无论nums和谁比，都不可能比x小
                if cur.children[bitNum]:
                    cur=cur.children[bitNum]
                else:
                    return sum
        return sum+cur.cnt

    def sum(self,nums,x):
        self.root = self.Trie()
        self.max_bit=14
        ans=0
        self.add(nums[0])
        for i in range(1,len(nums)):
            ans+=self.get(nums[i],x)
            self.add(nums[i])
        return ans

    def countPairs(self, nums: List[int], low: int, high: int) -> int:
        # num最大20000，二进制15位，前缀数统计二进制，数的child大小为2，分别表示下一位是0和下一位是1（这道题的前缀数就是个二叉树）
        # 要求nums中i与j异或值在[low,high]中间，只要求出小于high的数量 - 小于low的数量
        return self.sum(nums,high)-self.sum(nums,low-1)