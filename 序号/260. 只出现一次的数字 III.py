class Solution:
    def singleNumber(self, nums: List[int]) -> List[int]:
        # 全部异或可以得到2个出现1次数的异或值x
        # 找到x随便一位为1的，即它俩不同的位，标记为y，假设a&y==y
        # 用y异或所有num，a相当于出现了2次，这一位会变为0，就可以求出b了
        x=0
        for num in nums:x^=num
        y=x&-x
        a=b=0
        for num in nums:
            if (y & num) == y:a^=num
            else:b^=num
        return [a,b]