class N:
    def __init__(self,name:str):
        self.name=name
        self.children = []
        self.dead = False

class ThroneInheritance:
    def __init__(self, kingName: str):
        self.root=N(kingName)
        self.d = {kingName:self.root}

    def birth(self, parentName: str, childName: str) -> None:
        parent = self.d[parentName]
        child = N(childName)
        parent.children.append(child)
        self.d[childName]=child

    def death(self, name: str) -> None:
        self.d[name].dead = True
    def getInheritanceOrder(self) -> List[str]:
        ans = []
        def dfs(node):
            if not node.dead:
                ans.append(node.name)
            for child in node.children:
                dfs(child)
        dfs(self.root)
        return ans


# Your ThroneInheritance object will be instantiated and called as such:
# obj = ThroneInheritance(kingName)
# obj.birth(parentName,childName)
# obj.death(name)
# param_3 = obj.getInheritanceOrder()