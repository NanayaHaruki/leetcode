class Solution() {
  /** n盏灯，presses是按压次数。有四种方式 a 全部  b 偶数  c 奇数  d 1+3k
   *  1 <= n <= 1000  0 <= presses <= 1000   */
  fun flipLights(n: Int, presses: Int): Int {
    // 灯1 受 acd控制
    // 灯2 受 ab 控制
    // 灯3 受 ac 控制
    // 灯4 受 abd控制
    // 灯5 受 ac 控制
    // 灯6 受 ab 控制
    
    // 灯7 受 acd控制
    // 灯8 受 ab 控制。。。
    
    // 每6盏灯一个循环，只要判断前6盏灯有多少中可能性就是全部灯的可能性
    // 灯5与灯3相同，灯6与灯2相同，只要判断前4盏灯状态即可
    // 灯3的状态取决与a+c次数的奇偶性，偶数等于没按。ac奇偶性知道了，灯1的状态则取决于d的奇偶。灯2取决与ab的奇偶，故灯4的abd中 ab的奇偶由灯2得出，d的奇偶由13得出。所以灯4的状态可由灯123得出，只要判断前3盏灯状态即可。
    
    // 三盏灯初始状态000，按a，则111。按b则010。按c，101。按d，100
    // 按a后为111
    //      再次 a，000； b，101; c,010; d,011
    // 按b后为010
    //      再次，a，101； b,000; c,111; d,110
    // 按c后101
    //      再按，a，010;  b,111; c,000; d,001
    // 按d后100
    //      再次，a,011;   b,110; c,001; d,000
    
    // 三盏灯状态总共有2^3=8种，按一次可以获得4种。按两次可以获得7种（少了只亮第一盏灯的情况）。按3次及以上都可以获得全部的8种情况（按2次做不到100，按3次只需要在按2次得到000的情况下，按d方式即可）
    
    // 剩下的代码就查表就行了
    if (presses == 0) return 1
    if (presses == 1) {
      if (n == 1) return 2
      if (n == 2) return 3
      return 4
    }
    if (presses == 2) {
      if (n == 1) return 2
      if (n == 2) return 4
      return 7
    }
    if (n == 1) return 2
    if (n == 2) return 4
    return 8
  }
}