class Solution {
public:
    uint32_t reverseBits(uint32_t n) {
        uint32_t l=1<<31,r=1;
        for(int i=0;i<16;i++,l=l>>1,r=r<<1){       
          if(((n&l)==l) && ((n&r)!=r)){
            // 左边是1 右边是0
            n^=l;n^=r;
          }else if((n&l)!=l && (n&r)==r){
            n^=l;n^=r;
          }
        }
        return n;
    }
};