class Solution:
    def dayOfTheWeek(self, day: int, month: int, year: int) -> str:
        import datetime
        w=("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday","Sunday")
        d = datetime.date(year,month,day)
        return w[d.weekday()]