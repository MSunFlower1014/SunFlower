package com.ma.algorithms.s2;

import java.util.Arrays;

/**
 * 归井排序算法 完全遵守分治模式。直观上其探作如下:
 * 分解:分解待排序的n个元素的序列成各具n/ 2个元素的两个子序列。
 * 解决，使用归并排序递归的排序两个子序列，
 * 合并:合井两个已排序的子序列以产生已排序的答案。
 * <p>
 * 时间复杂度 O(n lgn)
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] ints = new int[]{1, 5, 11, 6, 2};

        int[] sort = mergeSort(ints);
        System.out.println("args = " + Arrays.toString(sort));
    }

    public static int[] mergeSort(int[] ints) {
        if (ints.length <= 1) {
            return ints;
        }

        int aLength = ints.length / 2;
        int[] a = new int[aLength];
        int[] b = new int[ints.length - aLength];
        System.arraycopy(ints, 0, a, 0, aLength);
        System.arraycopy(ints, aLength, b, 0, b.length);


        a = mergeSort(a);
        b = mergeSort(b);
        return merge(a, b);
    }

    private static int[] merge(int[] a, int[] b) {
        int aLength = a.length;
        int bLength = b.length;

        int allLength = aLength + bLength;
        int[] result = new int[allLength];


        while (allLength > 0) {
            if (aLength <= 0) {
                result[allLength - 1] = b[bLength - 1];
                bLength--;
                allLength--;
            } else if (bLength <= 0) {
                result[allLength - 1] = a[aLength - 1];
                aLength--;
                allLength--;
            } else if (a[aLength - 1] > b[bLength - 1]) {
                result[allLength - 1] = a[aLength - 1];
                allLength--;
                aLength--;
            } else {
                result[allLength - 1] = b[bLength - 1];
                allLength--;
                bLength--;
            }

        }

        return result;
    }
}
