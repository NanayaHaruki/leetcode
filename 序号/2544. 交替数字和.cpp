class Solution {
public:
    int alternateDigitSum(int n) {
        string s=to_string(n);
        int ln = s.length();
        int op=1;
        if(ln%2==0){
            op=-1;
        }
        int ans=0;
        while(n){
            ans+=((n%10)*op);
            op*=-1;
            n/=10;
        }
        return ans;
    }
};