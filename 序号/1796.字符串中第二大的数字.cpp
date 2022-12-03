class Solution {
public:
    int secondHighest(string s) {
        char a='0'-1,b=a;
        for(char c:s){       
           if(c>'9') continue;
           if(c==b) continue;
           if(c>b){
               a=b;b=c;
           }else if(c>a){
               a=c;
           }
        }
        return a-'0';
    }
};