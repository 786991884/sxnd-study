package com.xubh.test;

/**
 * @author Lenovo
 * @date 2017-01-05
 * @modify
 * @copyright
 */
public class SortingAlgorithm2 {

    /**
     * 给定数组：int data[] = {9,2,7,19,100,97,63,208,55,78}
     * 一、直接插入排序(内部排序、O(n2)、稳定)
     * 原理：从待排序的数中选出一个来，插入到前面的合适位置。
     */

    public static int data[] = {9, 2, 7, 19, 100, 97, 63, 208, 55, 78};

    public static void insertSort() {
        int tmp, j = 0;
        for (int k = 0; k < data.length; k++) {//-----1-----
            tmp = data[k];
            j = k - 1;
            while (j >= 0 && tmp < data[j]) {//-----2-----
                data[j + 1] = data[j];
                j--;
            }
            data[j + 1] = tmp;//------3-------
        }
    }

    public static void main(String[] args) {
        print();
        System.out.println();
        insertSort();
        System.out.println();
        print();
    }

    public static void print() {
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
    }

    /**
     * 二、选择排序（O(n2)、不稳定）
     * 与直接插入排序正好相反，选择排序是从待排序的数中选出最小的放在已经排好的后面，这个算法选数耗时。
     */

    public static void selectSort() {
        int i, j, k, tmp = 0;
        for (i = 0; i < data.length - 1; i++) {
            k = i;
            for (j = i + 1; j < data.length; j++)
                if (data[j] < data[k])
                    k = j;
            if (k != i) {
                tmp = data[i];
                data[i] = data[k];
                data[k] = tmp;
            }
        }
    }

    /**
     * 三、快速排序（O(nlogn)、不稳定）
     * 快速排序简称快排，是一种比较快的排序，适合基本无序的数据，
     * 为什么这么说呢？下面我说下快排的思路：
     * 设置两个指针：i和j，分别指向第一个和最后一个，i像后移动，j向前移动，
     * 选第一个数为标准（一般这样做，当然快排的关键就是这个“标准”的选取），
     * 从后面开始，找到第一个比标准小的数，互换位置，然后再从前面，
     * 找到第一个比标准大的数，互换位置，第一趟的结果就是标准左边的都小于标准，
     * 右边的都大于标准（但不一定有序），分成两拨后，继续递归的使用上述方法，最终有序！
     */

    static class QuickSort {

        public int data[];

        private int partition(int array[], int low, int high) {
            int key = array[low];
            while (low < high) {
                while (low < high && array[high] >= key)
                    high--;
                array[low] = array[high];
                while (low < high && array[low] <= key)
                    low++;
                array[high] = array[low];
            }
            array[low] = key;
            return low;
        }

        public int[] sort(int low, int high) {
            if (low < high) {
                int result = partition(data, low, high);
                sort(low, result - 1);
                sort(result + 1, high);
            }
            return data;
        }
    }

    /**
     * 四、冒泡排序（稳定、基本有序可达O(n)，最坏情况为O(n2)）
     * 冒泡排序是一种很简单，不论是理解还是时间起来都比较容易的一种排序算法，
     * 思路简单：小的数一点一点向前起泡，最终有序。
     */

    public static void bubbleSort() {
        int i, j, tmp = 0;
        for (i = 0; i < data.length - 1; i++) {
            for (j = data.length - 1; j > i; j--) {
                if (data[j] < data[j - 1]) {
                    tmp = data[j];
                    data[j] = data[j - 1];
                    data[j - 1] = tmp;
                }
            }
        }
    }
}
