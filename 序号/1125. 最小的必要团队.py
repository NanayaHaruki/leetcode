class Solution:
    def smallestSufficientTeam(self, req_skills: List[str], people: List[List[str]]) -> List[int]:
        # 集合论，将技能映射到比特位上去
        skill_dict = {x:i for i,x in enumerate(req_skills)}
        # 将每个人会的技能的集合转为二进制存储
        n=len(people)
        peopel_skill=[0]*n
        for i,skills in enumerate(people):
            for s in skills:
                peopel_skill[i]|=(1<<skill_dict[s])

        @cache
        def dfs(i,j)->int:
            '''
            根据前i个人的能力，选出可以满足j的并集的最小人数集合
            '''
            if not j: # 如果目标是空集，那么不需要人
                return 0
            if i<0:
                return (1<<n)-1
            # 不选i
            a=dfs(i-1,j)
            # 选i,i会的技能前面的人可以不用会了
            b=dfs(i-1,j&~peopel_skill[i])| (1<<i)
            return a if a.bit_count() < b.bit_count() else b
        res = dfs(n-1,(1<<len(req_skills))-1) # 1<<n-1 表达的是集合[0,n)
        return [i for i in range(n) if (res>>i) & 1]