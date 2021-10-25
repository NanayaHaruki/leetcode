/**
 * 给定一个单词列表，只返回可以使用在键盘同一行的字母打印出来的单词。键盘如下图所示。
 *
 *
 * American keyboard
 *
 *
 * 示例1:
 *
 * 输入: ["Hello", "Alaska", "Dad", "Peace"]
 * 输出: ["Alaska", "Dad"]
 * 注意:
 *
 * 你可以重复使用键盘上同一字符。
 * 你可以假设输入的字符串将只包含字母。
 * @author:xzj
 * @date: 2018/8/29 9:17
 */
class Solution {
    public String[] findWords(String[] words) {
        List<String> res = new ArrayList<>();
        for(String word : words) {
            if(check(word)) res.add(word);
        }
        String[] resArr = new String[res.size()];
        for(int i = 0; i < res.size(); i++) {
            resArr[i] = res.get(i);
        }
        return resArr ;
    }

    String line1 = "QWERTYUIOPqwertyuiop";
    String line2 = "ASDFGHJKLasdfghjkl";
    String line3 = "ZXCVBNMzxcvbnm";

    boolean check(String word) {
        char c = word.charAt(0);
        if (line1.indexOf(c) > -1) {
            for(int i = 0; i < word.length(); i++) {
                if (line1.indexOf(word.charAt(i)) == -1) {
                    return false;
                }
            }
        } else if (line2.indexOf(c) > -1) {
            for(int i = 0; i < word.length(); i++) {
                if (line2.indexOf(word.charAt(i)) == -1) {
                    return false;
                }
            }
        } else if (line3.indexOf(c) > -1) {
            for(int i = 0; i < word.length(); i++) {
                if (line3.indexOf(word.charAt(i)) == -1) {
                    return false;
                }
            }
        }
        return true;
    }
}
