class Solution {
public:
    Node* copyRandomList(Node* head) {
        // 复制复杂链表
        // 第1遍遍历，只考虑next，创建新链表，同时用vector记录顺序，用map记录旧node与index的对应关系。
        // 第2遍遍历，考虑random的指向。原链表的random，通过map查出来索引，再将vector中通过索引取出新node，接在当前遍历节点上
        Node* preHead = new Node(0);
        preHead->next = head;
        Node * cur = preHead;
        vector<Node*> v;
        unordered_map<Node*,int> dict;
        int i = 0;
        Node* newPreHead = new Node(0);
        Node * p = newPreHead;
        while(cur->next!=nullptr){
          cur = cur->next;
          dict[cur]= i++;
          Node* newNode = new Node(cur->val);
          v.push_back(newNode);
          p->next = newNode;
          p=p->next;
        }
        cur=preHead;p=newPreHead;
        while(cur->next!=nullptr){
          cur = cur->next;
          p=p->next;
          Node* randomNode = cur->random;
          if (randomNode!=nullptr)
          {
            Node * newRandomNode = v[dict[randomNode]];
            p->random = newRandomNode;
          }
        }
        delete preHead;
        return newPreHead->next;
    }
};