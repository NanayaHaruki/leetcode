class TestExeJava {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(longestPalindrome("abbc"));
    }

    static public String longestPalindrome(String s) {
//        开头加^ 结尾加$， #把字符分隔开，这样在计算回文的时候就只用考虑奇数的问题了。
//        比如奇数回文  aba  ^#a#b#a#$  9个
//        比如偶数回文  aa   ^#a#a#$    7个
//        统统变成奇数回文来考虑
        StringBuilder sb = new StringBuilder("^#");
        for(int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i))
                    .append("#");
        }
        sb.append("$");

        String res = null;
        int maxLen = 0;
        for(int i = 1; i < sb.length()-1; i++) {
            int j = 1;
            while (i - j >=0 && i+j <=sb.length()-1) {
                if (sb.charAt(i - j) == sb.charAt(i + j)) {
                    j++;

                }else break;
            }
            j--;
            if (2*j+1 > maxLen) {
                maxLen = 2*j+1;
                res = sb.substring(i - j, i + j + 1);
            }
        }
        return res.replace("#","");


//        StringBuilder sb = new StringBuilder("^#");
//        for(int i = 0; i < s.length(); i++) {
//            sb.append(s.charAt(i))
//                    .append("#");
//        }
//        sb.append("$");
//        int[] arr = new int[sb.length()];
//        int center = 0, r = 0, maxLen = 0;
//        String res=null;
//        for(int i = 1; i < sb.length() - 1; i++) {
//            if (center < r)
//                arr[i] = Math.min(r - center, arr[2 * center - i]);
//            else arr[i] = 1;
//            while (sb.charAt(i + arr[i]) == sb.charAt(i - arr[i])) {
//                arr[i]++;
//            }
//            if (i + arr[i] > r) {
//                center = i;
//                r = i + arr[i];
//            }
//            if (arr[i] > maxLen) {
//                maxLen = arr[i];
//                res = sb.substring(i-arr[i]+1,i+arr[i]).replace('#','\0');
//            }
//        }
//        return res;
    }


    static int discovery(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length  //递归超出范围
                || grid[i][j] == -1 //-1说明这块区域已经探索过了
                || grid[i][j] == 0) { //0就中止探索
            return 0;
        }
        grid[i][j] = -1;
        return 1 + discovery(grid, i - 1, j) + discovery(grid, i + 1, j) + discovery(grid, i, j + 1) + discovery(grid, i, j - 1);
    }


}
