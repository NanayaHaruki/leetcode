class Solution:
    def maskPII(self, s: str) -> str:
        if 'A'<=s[0]<='z':
            diff=ord('a')-ord('A')
            tmp=''
            splitIndex = s.find('@')
            fstChar,lstChar = s[0],s[splitIndex-1]
            if fstChar<'a':
                fstChar=chr(ord(fstChar)+diff)
            if lstChar<'a':
                lstChar=chr(ord(lstChar)+diff)
            tmp=fstChar+'*****'+lstChar+'@'
            for i in range(splitIndex+1,len(s)):
                if s[i]=='.':
                    tmp+='.'
                elif s[i]<'a':
                    tmp+=chr(ord(s[i])+diff)
                else:
                    tmp+=s[i]
            return tmp
        else:
            nums=''
            for c in s:
                if '0'<=c<='9':
                    nums+=c
            n=len(nums)
            tmp='***-***-'
            if n==11:
                tmp='+*-'+tmp
            elif n==12:
                tmp='+**-'+tmp
            elif n ==13:
                tmp='+***-'+tmp
            return tmp+nums[-4:]
           