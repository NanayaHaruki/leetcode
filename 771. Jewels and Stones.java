import java.util.HashMap;
import java.util.Map;

/**
 *  给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
 *
 * J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
 *
 * 示例 1:
 *
 * 输入: J = "aA", S = "aAAbbbb"
 * 输出: 3
 * 示例 2:
 *
 * 输入: J = "z", S = "ZZ"
 * 输出: 0
 * 注意:
 *
 * S 和 J 最多含有50个字母。
 *  J 中的字符不重复。
 * @author:xzj
 * @date: 2018/9/6 14:19
 */
class Solution {
    public int numJewelsInStones(String J, String S) {
        int[] arr = new int[128];
        int res = 0;
        /* J 是宝石，字母表示宝石类别，字符A是65  字符z是122  所有英文字母都可以看成65~122的数字*/
//        arr[65]=1 就表示A是宝石
        for(int i = 0; i < J.length(); i++) arr[J.charAt(i)] = 1;
//        遍历S，看看哪些是宝石，加起来就是了
        for(int i = 0; i < S.length(); i++) if (arr[S.charAt(i)] == 1) res++;
        return res;
    }
}

