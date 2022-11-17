class Solution {
 public:
    vector<int> twoSum(vector<int>& numbers, int target) {
      int n=numbers.size();
        for(int i=0;i<n-1;i++){
          auto it = lower_bound(numbers.begin()+i+1,numbers.end(),target-numbers[i]);
          if(it==numbers.end()) continue;
          if(*it == target-numbers[i]) return {i+1,(int)(1+it-numbers.begin())};
        }
        return {};
    }
};