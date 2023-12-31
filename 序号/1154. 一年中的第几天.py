import datetime
class Solution:
    def dayOfYear(self, date: str) -> int:
        return datetime.datetime.strptime(date,'%Y-%m-%d').timetuple().tm_yday