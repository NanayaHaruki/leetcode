class Solution {
public:
    /** boxTypes[i][j] 第i\U0001f004箱子有多少个 每个i箱子能装j个；总共卡车能装truckSize个箱子，求最大装载量 */
    int maximumUnits(vector<vector<int>>& boxTypes, int truckSize) {
      sort(boxTypes.begin(),boxTypes.end(),[](const vector<int> &type1,const vector<int>&type2){
        return type1[1]<type2[1];
      });
      int idx=boxTypes.size()-1,ans=0;
      while(idx>=0 && truckSize>0){
        if(truckSize>=boxTypes[idx][0]){ // 当前idx对应的箱子能全部装上
          truckSize-=boxTypes[idx][0];
          ans+=(boxTypes[idx][1]*boxTypes[idx][0]);
        }else{ // 只能装truckSize大小的箱子了
          ans+=(boxTypes[idx][1]*truckSize);
          truckSize=0;
        }
        idx--;
      }
      return ans;
    }
};