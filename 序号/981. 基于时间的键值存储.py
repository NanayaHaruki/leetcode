from bisect import bisect_right
class TimeMap:

    def __init__(self):
      self.d={} # key 就是key value 为[(value,time)]

    def set(self, key: str, value: str, timestamp: int) -> None:
      if key in self.d:
        self.d[key].append((value,timestamp))
      else:
        self.d[key]=[(value,timestamp)]

    def get(self, key: str, timestamp: int) -> str:
      d=self.d
      if key not in d:
        return ''
      li = d[key]
      l,r=-1,len(li)
      while l+1<r:
        m=(l+r)//2
        if li[m][1]<=timestamp:
          l=m
        else:
          r=m
      if l==-1:
        return ''
      return li[l][0]



# Your TimeMap object will be instantiated and called as such:
# obj = TimeMap()
# obj.set(key,value,timestamp)
# param_2 = obj.get(key,timestamp)