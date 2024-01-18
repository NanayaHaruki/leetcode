class Solution:
    def escapeGhosts(self, ghosts: List[List[int]], target: List[int]) -> bool:
        # 如果可以被中途拦截，鬼比人先到某个点，等人到了一起手拉手走向终点，
        # 不改变结局，但是鬼到终点的时间会比人少。 那不如直接算所有鬼到终点的时间 是不是比人快就好了
        tx,ty = target
        dis = abs(tx)+abs(ty)
        mnD = inf
        for x,y in ghosts:
            mnD = min(mnD,abs(x-tx)+abs(y-ty))
        return dis<mnD


