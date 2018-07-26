// 加1  1,2,3  变成124
class Solution {
    public int[] plusOne(int[] digits) {
        for(int i = (digits.length - 1); i >= 0; i--) {
        	// 从个位开始找，如果小于9，直接+1即可；否则该位设为0，并且进一位，进一位后继续判断是否小于9；小于直接+1返回，否则继续循环往前进位
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            } else {
                digits[i] = 0;
            }
        }
        // 走到这里还没有return说明int是99999这种了，那么直接数组长度+1，首位设为1即可
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }
}
