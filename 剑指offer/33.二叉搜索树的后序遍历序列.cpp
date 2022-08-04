class Solution {
 public:
    bool check(vector<int>& v,int start,int end){
      if(start>=end) return true;
      int root = v[end];
      int firstRightTreeIndex = -1;
      for(int i = start;i<end;i++){
        if(v[i]>root){
          firstRightTreeIndex=i;
          break;
        }
      }
      if(firstRightTreeIndex==-1){
        // 找不到右树
        return check(v,start,end-1);// 左树存在，继续递归
      }else{
        // 找到右树，判断右树都大于root
        for(int i = firstRightTreeIndex+1;i<end;i++){
          if(v[i]<=root) return false;
        }
        if(firstRightTreeIndex>start){
          // 左树也存在，都要查
          return check(v,start,firstRightTreeIndex-1) && check(v,firstRightTreeIndex,end-1);
        }else{
          return check(v,start,end-1);
        }
      }
    }
    bool verifyPostorder(vector<int>& postorder) {
      // 判断是否为后序遍历 左树 右树 根，且bst 左树所有节点 < 根 < 右树所有节点
      // 数组最后一个数为最上层的根，从左到右数的第一个大于根的即为右树的节点，由此划分出左右树的范围；
      // 因为上一条遍历过左树了，可以确保所有数小于根，所以需要判断右树是否所有值都是大于根的
      return check(postorder,0,postorder.size()-1);
    }
};