// 买股票，数组里是每天的股价，只能买卖一次，求最优解
class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length >= 2) {
        	int min = prices[0];
        	int maxDp = 0;
        	for(int i=1;i<prices.length;i++) {
        		if(min > prices[i]) {
        			min = prices[i];
        		}else if(maxDp < prices[i] - min) {
        			maxDp = prices[i] - min;
        		}
        	}
        	return maxDp;
        }else {
        	return 0;
        }
    }
}

