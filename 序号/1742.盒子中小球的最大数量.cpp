class Solution {
public:
    int countBalls(int lowLimit, int highLimit) {
        int boxes[46]{0};
        for(int i=lowLimit;i<=highLimit;i++){
            int j = i,boxIndex=0;
            while(j>0){
                boxIndex+=j%10;
                j/=10;               
            }
            boxes[boxIndex]++;
        }
        int ans=0;
        for(int i =0;i<46;i++){
            ans=max(ans,boxes[i]);
        }
        return ans;
    }
};