MOD = 1_000_000_007
MAX_N = 10_000

# EXP[x] 为 x 分解质因数后，每个质因数的指数
EXP = [[] for _ in range(MAX_N + 1)]
for x in range(2, len(EXP)):
    t = x
    i = 2
    while i * i <= t:
        e = 0
        while t % i == 0:
            e += 1
            t //= i
        if e:
            EXP[x].append(e)
        i += 1
    if t > 1:
        EXP[x].append(1)

class Solution:
    def idealArrays(self, n: int, maxValue: int) -> int:
        ans = 0
        for x in range(1, maxValue + 1):
            res = 1
            for e in EXP[x]:
                res = res * comb(n + e - 1, e) % MOD
            ans += res
        return ans % MOD