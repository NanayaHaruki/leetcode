// nums里是一条街上人家里的钱，挨着的2家之间都有连锁报警，怎么偷最大
class Solution {
    public int rob(int[] nums) {
    	// 这不就是偷奇数家还是偷偶数家么？ 不，并不是偷得家的数目越多数字越大的  比如 13119  奇数119=11  偶数31=4  而最大的偷法是39=12

    	// 一家家摸过去，noRob和rob 存储的是上一家没有没偷和偷后的总值
    	int noRob =0;
    	int rob = 0;
    	for(int n : nums) {
    		// 偷了这家，肯定不能偷上一家
    		int curRob = noRob + n;
    		// 不偷这家的话，找出偷于不偷上一家中的较大值 赋值给noRob
    		noRob = Math.max(noRob,rob);
    		// 将偷了这家后的总值赋值给rob
    		rob = curRob;
    	}
    	return Math.max(noRob,rob);
    }
}


