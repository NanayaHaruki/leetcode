class Solution {
private:
 int check(vector<int> &v,vector<int>& nums,int k){
     for(int i=k;i<=nums.size()-v.size();i++){
         int m = i;
         for(int j=0;j<v.size();j++){
             if(v[j]==nums[m]) m++;
             else break;
         }
         if(m==i+v.size()) return m;
     }
     return -1;
 }
public:
    bool canChoose(vector<vector<int>>& groups, vector<int>& nums) {
        int k = 0;
        for(auto & v:groups){
            int  res = check(v,nums,k);
            // cout<<"res:"<<res<<endl;
            if(res>=0) k = res;
            else return false;
        }
        return true;
    }
};