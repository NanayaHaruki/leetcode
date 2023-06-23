class Solution:
    def maximumValue(self, strs: List[str]) -> int:
        ans=0
        for s in strs:
            is_int=True
            for c in s:
                if '0'<=c<='9':
                    continue
                is_int=False
                break
            if is_int:
                ans=max(ans,int(s))
            else:
                ans=max(ans,len(s))
        return ans