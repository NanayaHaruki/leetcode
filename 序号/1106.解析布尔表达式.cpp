class Solution {
 public:
  bool parseBoolExpr(string expression) {
    char c = expression[0];
    if (c == 'f') return false;
    if (c == 't') return true;
    if (c == '!')
      return !parseBoolExpr(expression.substr(
          2, expression.length() -
                 3));  //起始点为2，0是！ 1是（。长度扣掉3，一堆（）和！
    int r = expression.length() - 2;
    if (c == '&') {
      for (int i = 2; i <= r; i++) {
        char c = expression[i];
        if (c == '&' || c == '|' || c == '!') {
          // 直接按照括号数量，截取该运算符表达式
          int cnt = 1, j = i + 2;
          while (cnt > 0) {
            if (expression[j] == ')')
              cnt--;
            else if (expression[j] == '(')
              cnt++;
            j++;
          }
          // j在括号后面的位置，应该是个逗号
          bool curRes = parseBoolExpr(expression.substr(i, j - i));
          if (!curRes) return false;
          i = j;
        } else if (c == 't') {
          continue;
        } else if (c == 'f') {
          return false;
        }
      }
      return true;
    } else if (c == '|') {
      for (int i = 2; i <= r; i++) {
        char c = expression[i];
        if (c == '&' || c == '|' || c == '!') {
          // 直接按照括号数量，截取该运算符表达式
          int cnt = 1, j = i + 2;
          while (cnt > 0) {
            if (expression[j] == ')')
              cnt--;
            else if (expression[j] == '(')
              cnt++;
            j++;
          }
          // j在括号后面的位置，应该是个逗号
          bool curRes = parseBoolExpr(expression.substr(i, j - i));
          if (curRes) return true;
          i = j;
        } else if (c == 't') {
          return true;
        } else if (c == 'f') {
          continue;
        }
      }
      return false;
    }
    return false;
  }
};