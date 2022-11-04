class Solution {
public:
    /** 第n步步长为n，最少步数到达target */
    int reachNumber(int target) {
      // 如果走了n步跨过了target，多出的步数是偶数i，那么可以在i/2步反向走，就可以刚好抵消。
      int steps = 0,len=0;
      target = abs(target);
      while(len<target){
        steps++;
        len+=steps;
      }
      // 当走过的距离len与target奇偶性相同的时候，都可以直接返回
      if(len==target) return steps;
      int diff = len-target;
      if(diff%2==0) return steps;
      // 奇偶性不同，分情况考虑，target奇数，len偶数
      // 观察len与step的规律
      //      1+ 2+ 3+4+ 5+ 6+ 7 +8
      //step  奇 偶 奇 偶 奇 偶 奇 偶
      // len  奇 奇 偶 偶 奇 奇 偶 偶 
      // 奇偶对应关系4轮一个循环
      // 只要让len与target奇偶性相同即可，
      // a.让len从奇变偶， 1.step为偶，再走一步即可（2-3那里）；2. step为奇数，需要再走2步（1-3）
      // b.让len从偶变奇数，1.step为奇数需要2步(3-5) 2. step为偶数，需要1步(4-5)
      // 由a-1,a-2,b-1,b-2四种组合情况可以看出，想要转变len的奇偶性与len无关，step为奇数需要2步，step为偶数需要1步
      if(steps%2==0) return steps+1;
      else return steps+2;
    }
};