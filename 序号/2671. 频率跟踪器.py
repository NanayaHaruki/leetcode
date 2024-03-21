class FrequencyTracker:

    def __init__(self):
        self.d1=Counter() # d1[1] 出现1次的数字有几个
        self.d2=Counter() # d2[1] 1这个数字出现了几次

    def add(self, number: int) -> None:
        cnt = self.d2[number]
        if cnt>0:
            self.d1[cnt]-=1
        self.d2[number]+=1
        self.d1[cnt+1]+=1

    def deleteOne(self, number: int) -> None:
        cnt = self.d2[number]
        if cnt>0:
            self.d2[number]=cnt-1
            self.d1[cnt]-=1
            self.d1[cnt-1]+=1

    def hasFrequency(self, frequency: int) -> bool:
        return self.d1[frequency]>0


# Your FrequencyTracker object will be instantiated and called as such:
# obj = FrequencyTracker()
# obj.add(number)
# obj.deleteOne(number)
# param_3 = obj.hasFrequency(frequency)