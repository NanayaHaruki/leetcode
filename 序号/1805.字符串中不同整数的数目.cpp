class Solution {
 public:
  int numDifferentIntegers(string word) {
    string a = "";
    bool is_add = false;
    word += 'a';
    unordered_set<string> set;
    for (char c : word) {
      if (c > '9') {
        if (!a.empty() && !is_add) {
          auto l = a.find_first_not_of('0');
          if (l != string::npos) {
            set.emplace(a.substr(l));
            a = "";
          }else{
              set.emplace("0");
          }
          is_add=true;
        }
      } else {
        is_add = false;
        a += c;
      }
    }
    return set.size();
  }
};