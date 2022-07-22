    int intersectionSizeTwo(vector<vector<int>>& intervals) {
        // 找到一个集合，让每个intervals[i]的区间内至少有2个数
        // 按照右边界升序排序，每次找最大值和次大值可以尽量重合
        // 右边界相同，按降序对左边界排序，保证后遍历的区间是前面遍历的子区间
        sort(intervals.begin(),intervals.end(),[&](vector<int> &a,vector<int> &b){
          if(a[1]==b[1]) return a[0]>b[0];
          return a[1]<b[1];
        });


        // 如果左边界比前面区间的右边界更大，那么需要新添加2个数
        // 如果左边界=前面区间的右边界，则两个区间共有一个元素，为满足新区间要2个元素存在答案中，需要添加一个元素，即新区间最大值
        // 如果左边界<前面区间的右边界，说明两个区间共有元素已经》=2了，不需要再添加元素

        // 题目不需要返回集合，只要集合的个数，那么只要统计即可
        int a=-1,b=-1,ans=0;
        for(const vector<int> &i : intervals){
          cout<<i[0]<<'-'<<i[1]<<endl;
          if(i[0]>b){
            ans+=2;
            a=i[1]-1;b=i[1];
            cout<<a<<','<<b;
          }else if(i[0]>a){
            ans++;
            a=b;b=i[1];
            cout<<','<<b<<endl;
          }
        }
        return ans;
    }