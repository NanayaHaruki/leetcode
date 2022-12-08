class Solution {
public:
    bool squareIsWhite(string coordinates) {
      int a = coordinates[0]-'a',b=coordinates[1]-'1';
      return (a+b)%2==1;
    }
};