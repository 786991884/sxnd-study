package ch04;

public class PriorityQueue {
    // 数组
    private long[] arr;

    // 最大空间
    private int maxSize;

    // 有效元素大小
    private int elems;


    public PriorityQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new long[maxSize];
        elems = 0;
    }

    // 插入数据
    public void insert(long value) {
        int i;
        for (i = 0; i < elems; i++) {
            if (value < arr[i]) {
                break;
            }
        }

        for (int j = elems; j > i; j--) {
            arr[j] = arr[j - 1];
        }
        arr[i] = value;
        elems++;
    }

    // 移除数据
    public long remove() {
        long value = arr[elems - 1];
        elems--;
        return value;
    }

    // 是否为空
    public boolean isEmpty() {
        return (elems == 0);
    }

    // 是否满了
    public boolean isFull() {
        return (elems == maxSize);
    }

    // 返回有效元素大小
    public int size() {
        return elems;
    }
}
