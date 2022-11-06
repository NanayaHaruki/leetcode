/**时间4 ms
击败
19.38%
内存6 MB
击败
25.61%*/
class Solution {
public:
    string interpret(string command) {
        string ans;int len=command.length();char c;
        for(int i=0;i<len;i++){
            c=command[i];
            if(c=='G') ans+='G';
            else if(c=='(') continue;
            else if(c==')') {
                if(command[i-1]=='(') ans+='o';
                else if(command[i-1]=='l') ans+="al";
            }
        }
        return ans;
    }
};