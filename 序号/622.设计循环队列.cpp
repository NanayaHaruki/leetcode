class MyCircularQueue {
 private:
  int *begin;
  int *end;
  int *insert;  // 指向可以插入的位置，即队尾的下一个
  int *pop;     // 指向删除的位置，即队首

 public:
  MyCircularQueue(int k) {
    // 循环队列，用2个指针表示从哪插，从哪取
    begin = new int[k]{-1};
    end = begin + k;
    insert=begin;pop=begin;
    int * i = begin;
    while(i!=end){
      *i = -1;
      i++;
    }
  }

  bool enQueue(int value) {
    if (*insert == -1) {
      *insert = value;
      insert++;
      if (insert == end) insert = begin;
      return true;
    } else
      return false;
  }

  bool deQueue() {
    if (*pop != -1) {
      *pop = -1;
      pop++;
      if (pop == end) pop = begin;
      return true;
    } else
      return false;
  }

  int Front() { return *pop; }

  int Rear() {
    if (insert == begin) {
      return *(end - 1);
    } else {
      return *(insert - 1);
    }
  }

  bool isEmpty() {
    if (insert == pop) {
      if (*insert == -1)
        return true;
      else
        return false;
    } else {
      return false;
    }
  }

  bool isFull() {
    if (insert == pop) {
      if (*insert == -1)
        return false;
      else
        return true;
    } else {
      return false;
    }
  }
};