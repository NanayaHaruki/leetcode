//
/**
 * 买股票，数组里是每天的股价，可以买卖多次，求最优解
 * Input: [7,1,5,3,6,4]
 * Output: 7
 * 1入5出   挣4
 * 3入6出    挣3
 * 合计挣7
 * 必须卖了才能再买，且不能同一天同时买卖
 * */
class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length >= 2) {
        	int min = prices[0];
        	int maxDp = 0;
        	for(int i=1;i<prices.length;i++) {
        		if(min > prices[i]) {
        			min = prices[i];
        		}else if(0 < prices[i] - min) {
        			maxDp += (prices[i] - min);
        		}
        	}
        	return maxDp;
        }else {
        	return 0;
        }
    }
}

