//64 / 64 个通过测试用例
//   执行用时: 36 ms
//   内存消耗: 19.3 MB
class MyLinkedList {
  struct Node {
    int i;
    Node* next;
    Node* prev;
  };
  int size = 0;
  Node* head = nullptr;
  Node* tail = nullptr;

 private:
  Node* getNode(int index) {
    if (size == 0) return nullptr;
    if (index >= size) return nullptr;

    if (index <= size / 2) {
      Node* p = head;
      for (int i = 0; i < index; i++) {
        p = p->next;
      }
      return p;
    } else {
      Node* t = tail;
      for (int i = 0; i < size - 1 - index; i++) {
        t = t->prev;
      }
      return t;
    }
  }

 public:
  MyLinkedList() {}

  int get(int index) {
    Node* node = getNode(index);
    if (node) {
      return node->i;
    } else {
      return -1;
    }
  }

  void addAtHead(int val) {
    Node* newHead = new Node{val};
    if (size == 0) {
      head = newHead;
      tail = head;
    } else {
      newHead->next = head;
      head->prev = newHead;
      head = newHead;
    }
    size++;
  }

  void addAtTail(int val) {
    Node* newTail = new Node{val};
    if (size == 0) {
      tail = newTail;
      head = tail;
    } else {
      tail->next = newTail;
      newTail->prev = tail;
      tail = newTail;
    }
    size++;
  }

  void addAtIndex(int index, int val) {
    if(index>size) return;
    if (index <= 0) {
      addAtHead(val);
    } else if (index == size) {
      addAtTail(val);
    } else {
      Node* node = getNode(index);
      Node* prev = node->prev;
      Node* newNode = new Node{val};
      if (prev) {
        prev->next = newNode;
      }
      newNode->next = node;
      node->prev = newNode;
      newNode->prev = prev;
      size++;
    }
  }

  void deleteAtIndex(int index) {
    Node* node = getNode(index);
    if (!node) return;
    if (size == 1) {
      head = nullptr;
      tail = nullptr;
    } else if (node == head) {
      head = head->next;
    } else if (node == tail) {
      tail = tail->prev;
    } else {
      Node* prev = node->prev;
      Node* next = node->next;
      prev->next = next;
      next->prev = prev;
    }
    size--;
  }
};