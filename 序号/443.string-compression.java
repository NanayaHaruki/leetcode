// 压缩字符数组，重复的字符用数字表示重复次数，数组中每个元素的长度都是1
// Input:
// ["a","a","b","b","c","c","c"]
// Output:
// Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]
class Solution {
    public int compress(char[] chars) {
        int compress = 0;
        int spaceIndex = 0;
        for (int i = 0; i < chars.length; i++) {
            if (i == chars.length - 1) break;
            if (i < spaceIndex || chars[i] == 0) continue;
            char c = chars[i];
//            count记录c出现的次数
            int count = 1;
            int differentIndex = 0;
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[j] == c) {
                    chars[j] = 0;
                    ++count;
                } else {
                    differentIndex = j;
                    break;
                }
            }
            String countStr = String.valueOf(count);
            if (count > 1) {
                for (int k = 0; k < countStr.length(); k++) {
                    chars[i + 1 + k] = countStr.charAt(k);
                }
            }
//            有3个重复的才需要将后面元素左移 ；比如 a a a  压缩成a12 3  第3个a的位置空出来了
            if (count > 2) {
                spaceIndex = i + countStr.length() + 1;
                compress += count - countStr.length() - 1;
//                differentIndex==0的话，说明是最后一个重复字符了，不需要左移了
                for (int l = 0; differentIndex != 0 && differentIndex+l < chars.length; l++) {
                    chars[spaceIndex+l] = chars[differentIndex+l];
                    chars[differentIndex+l] = 0;
                }
            } else {
                spaceIndex = i + count;
            }
        }
        // System.out.println(chars);
        return chars.length - compress;
    }
}
