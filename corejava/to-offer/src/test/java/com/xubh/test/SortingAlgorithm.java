package com.xubh.test;

/**
 * 排序算法整理
 *
 * @author Lenovo
 * @date 2017-01-05
 * @modify
 * @copyright
 */
public class SortingAlgorithm {


    //查找算法

    /**
     * 典型的二分查找
     * 对于二分查找算法要求, 查找前的数据必须是已经排好序的,
     * 然后得到数组的开始位置start和结束位置end,
     * 取中间位置mid的数据a[mid]跟待查找数据key进行比较,
     * 若 a[mid] > key, 则取end = mid - 1;
     * 若 a[mid] < key, 则取start = mid + 1;
     * 若 a[mid] = key 则直接返回当前mid为查找到的位置.
     * 依次遍历直到找到数据或者最终没有该条数据.
     */

    //已经排好序的数组
    public static int binarySearch(int[] nums, int key) {
        int start = 0;
        int end = nums.length - 1;
        int mid = -1;
        while (start <= end) {
            mid = (start + end) / 2;
            if (nums[mid] == key) {
                return mid;//已经查到返回！
            } else if (nums[mid] > key) {
                end = mid - 1;
            } else if (nums[mid] < key) {
                start = mid + 1;
            }
        }
        return -1;
    }

    //排序算法

    /**
     * 务必注意: 以下所有的排序算法都是从1开始, 而不是从0开始, 有的排序算法会把0位置当作监视哨
     * 排序之前先写一个交换方法后面会用到
     */
    private static void swap(int[] a, int i, int j) {
        a[i] ^= a[j];
        a[j] ^= a[i];
        a[i] ^= a[j];
    }

    //插入排序

    /**
     * 插入排序的基本思想是，经过i-1遍处理后,L[1..i-1]己排好序。
     * 第i遍处理仅将L[i]插入L[1..i-1]的适当位置，使得L[1..i] 又是排好序的序列。
     * 要达到这个目的，我们可以用顺序比较的方法。
     * 首先比较L[i]和L[i-1]，如果L[i-1]≤ L[i]，则L[1..i]已排好序，第i遍处理就结束了；
     * 否则交换L[i]与L[i-1]的位置，继续比较L[i-1]和L[i-2]，
     * 直到找到某一个位置j(1≤j≤i-1)，使得L[j] ≤L[j+1]时为止。
     * 图1演示了对4个元素进行插入排序的过程，共需要(a),(b),(c)三次插入
     * 稳定，时间复杂度 O(n^2)
     */
    public static void insertSort(int[] a) {//a0为监视哨位置,不作为数据存储
        int len = a.length;
        for (int i = 2; i < len; i++) {
            if (a[i - 1] > a[i]) {
                a[0] = a[i];
                a[i] = a[i - 1];
                int j = 0;
                for (j = i - 2; a[j] > a[0]; j--) {
                    a[j + 1] = a[j];
                }
                a[j + 1] = a[0];
            }
        }
    }

    //选择排序

    /**
     * 选择排序的基本思想是对待排序的记录序列进行n-1遍的处理，
     * 第i遍处理是将L[i..n]中最小者与L[i]交换位置。
     * 这样，经过i遍处理之后，前i个记录的位置已经是正确的了。
     * 不稳定, 时间复杂度 O(n^2)
     */

    public static void selectSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int j = selectMinKey(a, i); //从i开始a.length中找到最小的位置
            if (i != j) {
                swap(a, i, j);
            }
        }
    }

    // 查找从i开始到a.length中最小的位置
    private static int selectMinKey(int[] a, int i) {
        int key = i;
        for (int j = i + 1; j < a.length; j++) {
            if (a[j] < a[key]) {
                key = j;
            }
        }
        return key;
    }

    //冒泡排序

    /**
     * 冒泡排序方法是最简单的排序方法。
     * 这种方法的基本思想是，将待排序的元素看作是竖着排列的“气泡”，较小的元素比较轻，从而要往上浮。
     * 在冒泡排序算法中我们要对这个“气泡”序列处理若干遍。
     * 所谓一遍处理，就是自底向上检查一遍这个序列，并时刻注意两个相邻的元素的顺序是否正确。
     * 如果发现两个相邻元素的顺序不对，即“轻”的元素在下面，就交换它们的位置。
     * 显然，处理一遍之后，“最轻”的元素就浮到了最高位置；处理二遍之后，“次轻”的元素就浮到了次高位置。
     * 在作第二遍处理时，由于最高位置上的元素已是“最轻”元素，所以不必检查。
     * 一般地，第i遍处理时，不必检查第i高位置以上的元素，因为经过前面i-1遍的处理，它们已正确地排好序。
     * 稳定，时间复杂度 O(n^2)
     */
    //冒泡排序
    public static void bubbleSort(int[] a) {
        int len = a.length;
        for (int i = 1; i < len - 1; i++) {
            for (int j = i; j < len - i; j++) {
                if (a[j + 1] < a[j]) {
                    swap(a, j + 1, j);
                }
            }
        }
    }

    //快速排序

    /**
     * 不稳定，时间复杂度 最理想 O(nlogn) 最差时间O(n^2)
     * <p>
     * 快速排序是对冒泡排序的一种本质改进。
     * 它的基本思想是通过一趟扫描后，使得排序序列的长度能大幅度地减少。
     * 在冒泡排序中，一次扫描只能确保最大数值的数移到正确位置，而待排序序列的长度可能只减少1。
     * 快速排序通过一趟扫描，就能确保某个数（以它为基准点吧）的左边各数都比它小，右边各数都比它大。
     * 然后又用同样的方法处理它左右两边的数，直到基准点的左右只有一个元素为止。
     */

    //快速排序
    public static void quickSort(int[] a, int low, int high) {
        //递归快速排序
        int pivotLoc = 0;//中心点
        if (low < high) {
            pivotLoc = partitionLoc(a, low, high);
            quickSort(a, low, pivotLoc - 1);
            quickSort(a, pivotLoc + 1, high);
        }
    }

    //获取到a的下标 low ~ high 中, a[low]的应该放的位置, 即左边的数 < a[low] 右边的数 > a[low]
    private static int partitionLoc(int[] a, int low, int high) {
        a[0] = a[low];
        while (low < high) {
            while (low < high && a[high] >= a[0]) {
                high--;
            }
            a[low] = a[high];
            while (low < high && a[low] <= a[0]) {
                low++;
            }
            a[high] = a[low];
        }
        a[low] = a[0];
        return low;
    }
}
