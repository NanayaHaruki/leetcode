class Solution:
    def lemonadeChange(self, bills: List[int]) -> bool:
        # 给5元 收好，5+1
        # 给10元，10+1 5-1
        # 给20，20不会用来给别人，没必要记录，判断手上是否有15
        a=b=0 # a表示手上有的5元 b表示10元
        for x in bills:
            if x==5:
                a+=1
            elif x==10:
                if a:
                    a-=1
                    b+=1
                else:
                    return False
            elif x==20:
                if a and b:# 5元比较 灵活，优先将10元找出去
                    a,b=a-1,b-1
                elif a>=3:
                    a-=3
                else:
                    return False
        return True