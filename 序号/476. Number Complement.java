import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个正整数，输出它的补数。补数是对该数的二进制表示取反。
 *
 * 注意:
 *
 * 给定的整数保证在32位带符号整数的范围内。
 * 你可以假定二进制数不包含前导零位。
 * 示例 1:
 *
 * 输入: 5
 * 输出: 2
 * 解释: 5的二进制表示为101（没有前导零位），其补数为010。所以你需要输出2。
 * 示例 2:
 *
 * 输入: 1
 * 输出: 0
 * 解释: 1的二进制表示为1（没有前导零位），其补数为0。所以你需要输出0。
 * @author:xzj
 * @date: 2018/9/13 17:42
 */
class Solution {
    public int findComplement(int num) {
        char[] arr = Integer.toString(num,2).toCharArray();
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == '0') arr[i] = '1';
            else arr[i] = '0';
        }
        return Integer.valueOf(String.valueOf(arr), 2);
    }


}



