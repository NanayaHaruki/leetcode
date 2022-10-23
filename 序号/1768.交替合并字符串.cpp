class Solution {
public:
    /** 交叉合并字符串 */
    string mergeAlternately(string word1, string word2) {
      auto it1 = word1.cbegin(),it2=word2.cbegin(),end1=word1.cend(),end2=word2.cend();
      string s;
      while(it1!=end1 || it2!=end2){
        if(it1!=end1) {
          s+=*it1;it1++;
        }
        if(it2!=end2){
          s+=*it2;it2++;
        }
      }
      return s;
    }
};