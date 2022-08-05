class Solution {
private:
public:
    char firstUniqChar(string s) {
        //统计只出现1次的字符
        unordered_map<char,int> d;
        for(char c:s){
          d[c]++;
        }
        for(char c:s){
            if(d[c]==1) return c;
        }
        return ' ';
    }
};