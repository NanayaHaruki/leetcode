/**
 * 找出数组中出现次数超过一半的数
 * @author:xzj
 * @date: 2018/7/27 11:36
 */
class Solution {
	public int majorityElement(int[] nums) {
		int half = nums.length/2;
		HashMap<Integer,Integer> m = new HashMap<>();
		for(int i:nums){
			int cnt = m.getOrDefault(i,0);
			if(cnt==half) return i;
			m.put(i,++cnt);
		}
		return 0;
	}
}

