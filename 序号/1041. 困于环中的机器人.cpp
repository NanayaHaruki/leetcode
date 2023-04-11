class Solution {
public:
    bool isRobotBounded(string instructions) {
        // 走完一圈后停在原点，则有环（不用管方向，反正走多少圈都回到原点了）

        // 走完没有回到原点，初始朝北，走完朝南了，那么2圈成环。
        // 走完朝东或朝西，四圈成环。 
        // 走完继续朝北，永远回不到原点。
        // 最多判断四圈，看有没有走到原点即可
        int n = instructions.size();
        int xy[2]{0,0};
        int d=0; // 0123 代表北东南西 R指令就是顺时针，方向+1即可；L指令方向-1；
        for(int i =0;i<4;i++){
            for(int j=0;j<n;j++){
                switch(instructions[j]){
                    case 'L':
                        if(d==0) d=3;
                        else d-=1;
                        break;
                    case 'R':
                        if(d==3) d=0;
                        else d+=1;
                        break;
                    case 'G':
                        switch(d){
                            case 0:
                                xy[1]+=1;
                                break;
                            case 1:
                                xy[0]+=1;
                                break;
                            case 2:
                                xy[1]-=1;
                                break;
                            case 3:
                                xy[0]-=1;
                                break;                          
                        }
                }
            }
            if (xy[0]==0 && xy[1]==0) return true;
        }
        return false;
    }
};