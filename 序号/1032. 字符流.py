class Node:
    def __init__(self):
        ''' char  a为0 b为1 。。。'''
        self.stop = False
        self.children=[None]*26

class StreamChecker:

    def __init__(self, words: List[str]):
        '''建立字典树，即26叉树'''
        self.cache = [] # 存放输入过的字符，word长度为最长200，cache长度最多不会超过200个
        top = Node()
        for word in words:
            node = top
            for c in reversed(word):
                idx = ord(c)-ord('a')
                next =  node.children[idx]
                if not next:
                    next = Node()
                    node.children[idx]=next
                node = next
            node.stop=True

        self.top = top

        


    def query(self, letter: str) -> bool:
        '''检查不断输入的字符，后缀在不在words中'''
        node = self.top
        self.cache.append(letter)
        if len(self.cache)>200:
            self.cache.pop(0)
        idx = len(self.cache)-1
        for i in range(idx,-1,-1):
            targetCharIndex = ord(self.cache[i])-ord('a')
            child = node.children[targetCharIndex]
            if child:
                if child.stop:
                    return True
                node = child
            else:
                return False
        return False
