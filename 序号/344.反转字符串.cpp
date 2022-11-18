class Solution {
public:
    void reverseString(vector<char>& s) {
        int n = s.size(),m=n/2;
        for(int i = 0;i<m;i++){
            s[i]=s[i]+s[n-1-i];
            s[n-1-i]=s[i]-s[n-1-i];
            s[i]=s[i]-s[n-1-i];
        }
    }
};