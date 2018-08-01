import com.sun.org.apache.bcel.internal.generic.SWAP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import java.util.function.Consumer;

class TestExeJava {
    public static void main(String[] args) {
        int[] arr = {0,1,0,3,12};
        System.out.println(thirdMax(arr));
    }

    static public int thirdMax(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        for(int num : nums) {
            set.add(num);
        }
//        TreeSet会自然排序 且值唯一。
//        如果没有3个值，last就是最大的
        if(set.size()<3) return set.last();
        else {
//            倒序迭代器，走3步即可
            Iterator<Integer> iterator = set.descendingIterator();
            iterator.next();
            iterator.next();
            Integer third = iterator.next();

            return third;
        }
    }


    static void printArr(int[] nums) {
        for(int i : nums) {
            System.out.print(i+" ");
        }
    }
}
