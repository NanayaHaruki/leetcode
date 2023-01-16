class Solution {
 private:
  vector<string> split(string& s, char dlm) {
    stringstream ss(s);
    string buffer;
    vector<string> v;
    while (getline(ss, buffer, dlm)) {
      v.emplace_back(buffer);
    }
    return v;
  }

 public:
  bool areSentencesSimilar(string sentence1, string sentence2) {
    vector<string> v1 = split(sentence1, ' '), v2 = split(sentence2, ' ');
    int i = 0, j = 0;
    while (i < v1.size() && i < v2.size() && v1[i] == v2[i]) i++;
    while (v1.size() - j -1>= 0 && v2.size() - j-1 >= 0 && v1[v1.size() - 1 - j] == v2[v2.size() - 1 - j]) {
        j++;
        cout<<j<<','<<v1.size()<<','<<v2.size()<<','<<(v1.size() - j -1)<<','<<( v2.size() - j-1 )<<endl;
    }
    return (i + j) >= min(v1.size(), v2.size());
  }
};