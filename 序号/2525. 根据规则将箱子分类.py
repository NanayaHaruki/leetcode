class Solution:
    def categorizeBox(self, length: int, width: int, height: int, mass: int) -> str:
        b=length>=10000 or width>=10000 or height>=10000 or length*width*height>=1000000000
        h=mass>=100
        if b:
            if h:return 'Both'
            else:return 'Bulky'
        else:
            if h:return 'Heavy'
            else:return 'Neither'