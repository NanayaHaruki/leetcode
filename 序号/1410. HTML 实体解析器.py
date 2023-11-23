
class Node:
    def __init__(self,c):
        self.c=c
        self.v=''
        self.children={}
class Solution:
    def entityParser(self, text: str) -> str:
       # build tree
       root=Node('&')
       def build(src:str,dst:str):
           p=root
           for i in range(1,len(src)):
               cur_char = src[i]
               if cur_char in p.children:
                   p=p.children[cur_char]
               else:
                   cur_node = Node(cur_char)
                   p.children[cur_char]=cur_node
                   p=cur_node
           p.v=dst
       build('&quot;','"')
       build('&apos;','\'')
       build('&amp;','&')
       build('&gt;','>')
       build('&lt;','<')
       build('&frasl;','/')
       ans=''
       node=None
       preIdx=0
       for i,x in enumerate(text):
           if not node and x=='&':
               node=root
               preIdx=i
               continue
           if node:
               if x in node.children:
                   node=node.children[x]
                   if node.v:
                       ans+=node.v
                       node=None
               else:    
                   
                   if x=='&':
                       ans+=text[preIdx:i]
                       node=root
                       preIdx=i
                   else:
                       ans+=text[preIdx:i+1]
                       node=None
           else:
               ans+=x
       if node:
           ans+=text[preIdx:]
       return ans