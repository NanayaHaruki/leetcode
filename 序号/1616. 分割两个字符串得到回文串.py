class Solution:
    def checkPalindromeFormation(self, a: str, b: str) -> bool:
        # 两端指针想中间移动，遇到不同的，
        #   则a的指针挪入b的相同位置，判断b剩余部分是否为回文
        #   或b指针挪入a的位置，继续判断a剩余部分是否回文
        n=len(a)
        def checkSelf(a,l,r):
            while l<r and a[l]==a[r]:
                l+=1
                r-=1
            return l>=r
        def check(a,b):
            l,r=0,n-1
            while l<r:                
                if a[l]==b[r]:
                    l+=1
                    r-=1
                else:
                    break
            if l>=r: # n为奇数，l和r会走到中心点；n为偶数，l会超过r
                return True
            return checkSelf(a,l,r) or checkSelf(b,l,r)        
        return check(a,b) or check(b,a)