    int nextGreaterElement(int n) {
        auto&& s = to_string(n);
        return !next_permutation(s.begin(), s.end()) || stol(s) > INT_MAX ? -1 : stoi(s);
    }