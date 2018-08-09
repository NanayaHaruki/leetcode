import com.sun.org.apache.bcel.internal.generic.SWAP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Queue;
import java.util.TreeSet;
import java.util.function.Consumer;

class TestExeJava {
    public static void main(String[] args) {
        int[][] arr = {{1,1,1},{1,0,1},{1,1,1}};
        for(int[] ints : imageSmoother(arr)) {
            for(int anInt : ints) {
                System.out.print(anInt);
            }
            System.out.println();
        }

    }

    static public int[][] imageSmoother(int[][] M) {
        int[][] result = new int[M.length][M[0].length];
        for(int i = 0; i < M.length; i++) {
            for(int j = 0; j < M[0].length; j++) {
//                到这里，是遍历二维数组的每个位置,对每个点进行灰度计算
//                灰度计算是该点周围8个点的平均值，也就是该点横纵坐标+-1的点
                int count = 0;
                int sum = 0;
                for(int k = -1; k < 2; k++) {
                    for(int l = -1; l < 2; l++) {
                        if (i + k < 0 || i + k >= M.length || j + l < 0 || j + l >= M[0].length) {
                            continue;
                        }
                        count++;
                        sum+=M[i+k][j+l];
                    }
                }
                result[i][j] = sum/count;
            }
        }
        return result;
    }

    private final static char[] mChars = "0123456789ABCDEF".toCharArray();
    public static String byte2HexStr(byte[] b, int iLen) {
        if (b == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int n = 0; n < iLen; n++) {
            sb.append(mChars[(b[n] & 0xFF) >> 4]);
            sb.append(mChars[b[n] & 0x0F]);
            sb.append(' ');
        }
        return sb.toString().trim().toUpperCase(Locale.US);
    }

    static void printArr(int[] nums) {
        for(int i : nums) {
            System.out.print(i + " ");
        }
    }
}
