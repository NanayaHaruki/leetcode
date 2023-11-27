class Solution:
    def subArrayRanges(self, nums: List[int]) -> int:
        # 贡献法  某数x如果是子数组最大值就会为答案贡献x，如果是最小值就会贡献-x
        # 单调栈 保证栈内升序，当一个数被弹，说明它的右边界出现了，而左边界就是栈内的前一个 即可求得作为最大值的贡献
        # 再弄个栈，存负数，用一样的逻辑可求出最小值的栈
        n=len(nums)
        ans=0
        mnst,mxst=[-1],[-1]
        nums.append(math.inf) # 为了让最后元素都弹栈，同时让第1个元素可以正确计算到
        for i,x in enumerate(nums): # 考虑最大值边界
            while nums[mxst[-1]]<x: # 将比 x 小的都弹栈就知道了 x的左边界，同时因为出现了更大的x，原栈顶的右边界也出现了
                j=mxst.pop()
                ans+=nums[j]*(i-j)*(j-mxst[-1])
                # print("mx:",nums[j],(i-j)*(j-mxst[-1]) )      
            mxst.append(i)
        nums[-1]=-math.inf
        for i,x in enumerate(nums):
            while nums[mnst[-1]]>x:
                j=mnst.pop()
                ans-=nums[j]*(i-j)*(j-mnst[-1])
                # print("mn:",nums[j],(i-j)*(j-mnst[-1]) )   
            mnst.append(i)
        return ans