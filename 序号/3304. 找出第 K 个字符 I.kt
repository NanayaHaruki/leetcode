class Solution {
  fun kthCharacter(k: Int): Char {
      // a - a b - ab bc,每次操作字符长度倍增，将最终的字符分成两半，操作n次，字符长度2^n
      // k < 2^(n-1)=1<<(n-1) 在左边，去找 k- (1 << (n-2)的位置
      // k在右半边，字符要+1,然后去找 k - （1 << (n-2)的位置
      // 题目本质是找 ’a' 增加了几次，其实就是找k在右半边的次数
      // k > 1<<i ,k+=(1<<i) 也就是找k中1的个数
      return 'a'+(k-1).countOneBits()%26
  }
}