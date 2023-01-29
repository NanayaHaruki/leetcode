class Solution {
public:
    int countAsterisks(string s) {
        int cnt=0;
        bool hasLeft=false;
        for(char c:s){
            if(hasLeft){
                if(c=='|'){
                    hasLeft=false;
                }
            }else{
                if(c=='|'){
                    hasLeft=true;
                }else if(c=='*'){
                    cnt++;
                }
            }
        }
        return cnt;
    }
};