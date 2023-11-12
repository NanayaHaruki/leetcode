auto _{ []() noexcept {
    std::ios::sync_with_stdio(false);
    std::cin.tie(nullptr); std::cout.tie(nullptr);
    return 0;
}() };

class Chtholly{
private:
    struct Node{
        int l,r,b;
        Node(int l,int r,int b):l(l),r(r),b(b){}
        bool operator< (Node const & o)const{
            return l < o.l;
        }
    };
public:
    std::set<Node> s;
    auto split(int x){
        auto it = s.lower_bound({x,0,0});
        if(it!=s.end() && it->l==x)return it;
        // it是x右边的节点
        auto [l,r,b]{*--it};
        s.erase(it);
        s.emplace(Node(l,x-1,b));
        auto ret = s.emplace(Node(x,r,b));
        return ret.first;
    }

    void assign(int l,int r,int b){
        auto rt=split(r+1),lt=split(l);
        s.erase(lt,rt);
        s.emplace(Node(l,r,b));
    }

    bool check(int l,int r){
        auto rt=split(r+1),lt=split(l);
        while(lt!=rt){
            if(lt->b){
                lt++;
            }else{
                return false;
            }
        }
        return true;
    }
};
class RangeModule {
public:
    Chtholly tree { {{1,1000000000,0}} };
    RangeModule() {

    }
    
    void addRange(int left, int right) {
        tree.assign(left,right-1,1);

    }
    
    bool queryRange(int left, int right) {
        return tree.check(left,right-1);
    }
    
    void removeRange(int left, int right) {
        tree.assign(left,right-1,0);
    }
};

/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule* obj = new RangeModule();
 * obj->addRange(left,right);
 * bool param_2 = obj->queryRange(left,right);
 * obj->removeRange(left,right);
 */