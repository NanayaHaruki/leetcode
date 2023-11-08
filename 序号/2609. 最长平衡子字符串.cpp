class Solution {
public:
    int findTheLongestBalancedSubstring(string s) {
        size_t len=s.length();
        int a,b,t,ans=0;
        if(s[0]=='0'){
            a=1;b=0;
        }else{
            a=b=0;
        }
        for(size_t i=1;i<len;i++){
            char c = s[i];
            if(c=='0'){
                if(s[i-1]=='0'){
                    a+=1;
                }else{
                    t=min(a,b);
                    ans=max(ans,t);
                    a=1;b=0;
                }

            }else{
                b+=1;
            }
        }
        t=min(a,b);
        ans=max(ans,t);
        return ans*2;
    }
};