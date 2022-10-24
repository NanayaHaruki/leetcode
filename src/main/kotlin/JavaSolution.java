import java.io.PrintStream;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: taoye
 * @Description:
 * @Date: 13:20 2019/2/18
 */

public class JavaSolution {
    public int findKthNumber(int m, int n, int k) {

        int left = 1, right = m * n;
        while (left < right) {
            int x = left + (right - left) / 2;
            int count = x / n * n;
            for (int i = x / n + 1; i <= m; ++i) {
                count += x / i;
            }
            if (count >= k) {
                right = x;
            } else {
                left = x + 1;
            }
        }
        return left;
    }
    public static class WordFilter  {
        class TrieNode {
            TrieNode[] tns = new TrieNode[26];
            List<Integer> idxs = new ArrayList<>();
        }
        void add(TrieNode p, String s, int idx, boolean isTurn) {
            int n = s.length();
            p.idxs.add(idx);
            for (int i = isTurn ? n - 1 : 0; i >= 0 && i < n; i += isTurn ? -1 : 1) {
                int u = s.charAt(i) - 'a';
                if (p.tns[u] == null) p.tns[u] = new TrieNode();
                p = p.tns[u];
                p.idxs.add(idx);
            }
        }
        int query(String a, String b) {
            int n = a.length(), m = b.length();
            TrieNode p = tr1;
            for (int i = 0; i < n; i++) {
                int u = a.charAt(i) - 'a';
                if (p.tns[u] == null) return -1;
                p = p.tns[u];
            }
            List<Integer> l1 = p.idxs;
            p = tr2;
            for (int i = m - 1; i >= 0; i--) {
                int u = b.charAt(i) - 'a';
                if (p.tns[u] == null) return -1;
                p = p.tns[u];
            }
            List<Integer> l2 = p.idxs;
            n = l1.size(); m = l2.size();
            for (int i = n - 1, j = m - 1; i >= 0 && j >= 0; ) {
                if (l1.get(i) > l2.get(j)) i--;
                else if (l1.get(i) < l2.get(j)) j--;
                else return l1.get(i);
            }
            return -1;
        }
        TrieNode tr1 = new TrieNode(), tr2 = new TrieNode();
        public WordFilter(String[] ss) {
            int n = ss.length;
            for (int i = 0; i < n; i++) {
                add(tr1, ss[i], i, false);
                add(tr2, ss[i], i, true);
            }
        }
        public int f(String a, String b) {
            return query(a, b);
        }
    }

}



