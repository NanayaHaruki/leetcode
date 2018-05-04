// widths数组大小为26  存放着字母a~z所占用的格数。一行100格，超过则换行，问字符串S写下来需要多少格
// 返回数组，第一个表示行数，第2个表示最后一行的格数
class Solution {
   public int[] numberOfLines(int[] widths, String S) {
        if(S.isEmpty()) return new int[]{0, 0};
//        因为'a'= 97，widths[char-97]即为char所占格数
        int line = 1,len = 0;
        for(int i = 0; i < S.length(); i++) {
            int charLength = widths[S.charAt(i)-97];
            if((len+charLength)>100) {
               len = charLength;
               line++;
            } else if (len + charLength == 100) {
                len = 0;
                line++;
            } else {
                len += charLength;
            }
        }
        return new int[]{line,len};
    }
}
