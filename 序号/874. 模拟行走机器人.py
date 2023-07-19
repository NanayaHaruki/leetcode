class Solution:
    def robotSim(self, commands: List[int], obstacles: List[List[int]]) -> int:
        # 如何快速判断障碍物在路线上。 
        ro,co={},{}
        for x,y in obstacles:
            if x in ro:
                ro[x].append(y)
            else:
                ro[x]=[y]
            if y in co:
                co[y].append(x)
            else:
                co[y]=[x]
        for r in ro:
            ro[r].sort()
        for c in co:
            co[c].sort()

        dx,dy,x,y,ans=0,1,0,0,0
        def turn(leftOrRight):
            nonlocal dx,dy
            if leftOrRight==-2:
                if dx==0 and dy==1:
                    dx,dy=-1,0
                elif dx==-1 and dy==0:
                    dx,dy=0,-1
                elif dx==0 and dy==-1:
                    dx,dy=1,0
                else:
                    dx,dy=0,1
            else:
                if dx==0 and dy==1:
                    dx,dy=1,0
                elif dx==1 and dy==0:
                    dx,dy=0,-1
                elif dx==0 and dy==-1:
                    dx,dy=-1,0
                else:
                    dx,dy=0,1
        for command in commands:
            if command<0:
                turn(command)
            else:
                nx,ny=x+dx*command,y+dy*command
                # 用例中有弱智的 0，0出现在障碍点，进行特判
            

                if dx==0 and dy==1: # 向上
                    if x  in ro:
                        idx=bisect.bisect_left(ro[x],y)
                        if idx==len(ro[x]) or ro[x][idx]>ny:# 没有比起始点更大的 或 比终点更大，本次可以走完
                            y=ny
                        else: # 走到障碍物前
                            if x==0 and y==0 and ro[x][idx]==0:
                                y=ny
                            else:
                                y=ro[x][idx]-1 
                    else:
                        y=ny
                elif dx==0 and dy==-1: # 向下
                    if x  in ro:
                        idx=bisect.bisect_left(ro[x],ny)
                        if idx==len(ro[x]) or ro[x][idx]>y:
                            y=ny
                        else:
                            if x==0 and y==0 and ro[x][idx]==0:
                                y=ny
                            else:
                                y=ro[x][idx]+1
                    else:
                        y=ny
                elif dx==1 and dy==0: # 向右
                    if y in co:
                        idx=bisect.bisect_left(co[y],x)
                        if idx==len(co[y]) or co[y][idx]>nx:
                            x=nx
                        else:
                            if x==0 and y==0 and co[y][idx]==0:
                                x=nx
                            else: 
                                x=co[y][idx]-1
                    else:
                        x=nx
                elif dx==-1 and dy==0: # 向左
                    if y in co:
                        idx=bisect.bisect_left(co[y],nx)
                        if idx==len(co[y]) or co[y][idx]>x:
                            x=nx
                        else:
                            if x==0 and y==0 and co[y][idx]==0:
                                x=nx
                            else:
                                x=co[y][idx]+1
                    else:
                        x=nx
                ans=max(ans,x*x+y*y)
        return ans