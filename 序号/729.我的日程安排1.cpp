class MyCalendar {
public:
    map<int,int> map;
    MyCalendar() {
        map[-1]=-1;
        map[1e9+1]=1e9+1;
    }
    bool book(int start, int end) {
        // start能与之相交的
        auto lt = map.lower_bound(start);
        if(lt->first>start) lt--;
        auto rt = map.lower_bound(start);
        if(lt->second <=start && rt->first>=end){
            map[start]=end;
            return true;
        }
        return false;
    }
};