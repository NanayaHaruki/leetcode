class Solution:
    def distMoney(self, money: int, children: int) -> int:
        if money<children:return -1
        if money==children*8:return children
        if money>children*8:return children-1
        money-=children # 先每人一个
        if money%7==3 and money//7+1==children:return money//7-1
        return money//7