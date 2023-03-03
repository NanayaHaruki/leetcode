from typing import List
from collections import Counter,defaultdict

class Solution:

    def getFolderNames(self, names: List[str]) -> List[str]:

        d = defaultdict(int)

        for i, name in enumerate(names):

            if name in d:

                k = d[name]

                while f'{name}({k})' in d:

                    k += 1

                d[name] = k + 1

                names[i] = f'{name}({k})'

            d[names[i]] = 1

        return names
    
ans = Solution().getFolderNames(['a','a','a(5)','a'])
print(ans)








        



