package com.ma.algorithms.s2;

import java.util.Arrays;

/**
 * 插入排序
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] ints = new int[]{1, 5, 11, 6, 2};
        insertSort(ints);
    }

    /**
     * 冒泡排序
     *
     * @param ints
     */
    public static void swapSort(int[] ints) {
        for (int i = 0; i < ints.length; i++) {
            for (int j = i + 1; j < ints.length; j++) {
                if (ints[j] < ints[i]) {
                    int key = ints[j];
                    ints[j] = ints[i];
                    ints[i] = key;
                }
            }
        }

        System.out.println("ints = " + Arrays.toString(ints));
    }

    /**
     * 插入排序
     * 时间复杂度 O(n²)
     * 空间复杂度O(n)
     *
     * @param ints
     */
    public static void insertSort(int[] ints) {
        for (int i = 1; i < ints.length; i++) {
            int j = i;
            while (j >= 0 && ints[j] < ints[j - 1]) {
                int key = ints[j];
                ints[j] = ints[j - 1];
                ints[j - 1] = key;
                j--;
            }
        }

        System.out.println("ints = " + Arrays.toString(ints));
    }


}
