class Solution {
public:
    int firstBadVersion(int n) {
        int l = 1,r=INT_MAX,m;
        while(l<=r){
            m = l+(r-l)/2;
            if(isBadVersion(m)){
                r=m-1;
            }else l=m+1;
        }
        return l;
    }
};