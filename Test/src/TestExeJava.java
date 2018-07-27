import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.function.Consumer;

class TestExeJava {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,6,4,3,1,2}));
    }

    static public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length >> 1];
    }
}
