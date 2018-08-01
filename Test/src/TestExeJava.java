import com.sun.org.apache.bcel.internal.generic.SWAP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;
import java.util.function.Consumer;

class TestExeJava {
    public static void main(String[] args) {
        int[] arr = {0,1,0,3,12};
        moveZeroes(arr);
    }

    static public void moveZeroes(int[] nums) {
        for(int i = 0; i < nums.length-1; i++) {
            if (nums[i] == 0) {
                for(int j = i+1; j < nums.length; j++) {
                    if (nums[j] != 0) {
                        swap(nums,i,j);
                        for(int k = j; k < nums.length-1; k++) {
                            swap(nums,k,k+1);
                        }
                        break;
                    }
                }
            }
        }
    }

    static void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }

    static void printArr(int[] nums) {
        for(int i : nums) {
            System.out.print(i+" ");
        }
    }
}
