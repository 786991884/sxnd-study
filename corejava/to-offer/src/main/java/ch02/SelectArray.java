package ch02;

public class SelectArray {
    // 数组
    private long[] arr;

    // 数组中有效数据的大小
    private int elems;

    // 默认构造函数
    public SelectArray() {
        arr = new long[50];
    }

    public SelectArray(int max) {
        arr = new long[max];
    }

    // 插入数据
    public void insert(long value) {
        arr[elems] = value;
        elems++;
    }

    // 显示数据
    public void display() {
        for (int i = 0; i < elems; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // 选择排序
    public void selectSort() {
        int min = 0;
        long tmp = 0L;
        for (int i = 0; i < elems - 1; i++) {
            min = i;
            for (int j = i + 1; j < elems; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            tmp = arr[i];
            arr[i] = arr[min];
            arr[min] = tmp;
        }
    }
}
