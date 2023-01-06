class Solution:
    def countEven(self, num: int) -> int:
        '''
        小于等于num 每一位加起来是偶数的正整数个数
        '''
        a = num//10*5 # 表示有多少个[1,3,5,7,9]或[2,4,6,8,0]
        b=num%10 # 个位数，小于等于b有多少个奇数或偶数
        c = num//10
        s=0
        while c:
            s+=c%10
            c//=10
        if s&1:  # 个位之外是奇数，需要个数是奇数
            a+=(b+1)//2
        else:
            a+=b//2+1
        return a-1