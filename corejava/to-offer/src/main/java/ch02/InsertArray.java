package ch02;

public class InsertArray {
    // 数组
    private long[] arr;

    // 数组中有效数据的大小
    private int elems;

    // 默认构造函数
    public InsertArray() {
        arr = new long[50];
    }

    public InsertArray(int max) {
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

    // 插入排序
    public void insertSort() {
        long select = 0L;
        for (int i = 1; i < elems; i++) {
            select = arr[i];
            int j = 0;
            for (j = i; j > 0 && arr[j - 1] >= select; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = select;
        }
    }
}
