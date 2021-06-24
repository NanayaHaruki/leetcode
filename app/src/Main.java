public class Main {
    public static void main(String[] args) {
        int res = maxPoints(new int[][]{{1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}});
        System.out.println(res);
    }

    public  static int maxPoints(int[][] ps) {
        int n = ps.length;
        int ans = 1;
        for (int i = 0; i < n; i++) {
            int[] x = ps[i];
            for (int j = i + 1; j < n; j++) {
                int[] y = ps[j];
                int cnt = 2;
                System.out.print(String.format("%d,%d  %d,%d ===",x[0],x[1],y[0],y[1]));
                for (int k = j + 1; k < n; k++) {
                    int[] p = ps[k];
                    int s1 = (y[1] - x[1]) * (p[0] - y[0]);
                    int s2 = (p[1] - y[1]) * (y[0] - x[0]);
                    if (s1 == s2) {
                        cnt++;
                        System.out.print(String.format("%d %d,",p[0],p[1]));
                    }
                }
//                ans = Math.max(ans, cnt);
                if (cnt>ans) ans = cnt;
                System.out.println();
            }
        }
        return ans;
    }

}
