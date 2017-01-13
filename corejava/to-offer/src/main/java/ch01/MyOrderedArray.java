package ch01;

public class MyOrderedArray {
    // 数组
    private long[] arr;

    // 数组中有效数据的大小
    private int elems;

    //默认构造函数
    public MyOrderedArray() {
        arr = new long[50];
    }

    public MyOrderedArray(int max) {
        arr = new long[max];
    }

    // 插入数据
    public void insert(long value) {
        int i;
        for (i = 0; i < elems; i++) {
            if (arr[i] > value) {
                break;
            }
        }

        for (int j = elems; j > i; j--) {
            arr[j] = arr[j - 1];
        }
        arr[i] = value;
        elems++;
    }

    // 显示数据
    public void display() {
        for (int i = 0; i < elems; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // 查找数据
    public int find(long searchKey) {
        int i;
        for (i = 0; i < elems; i++) {
            if (arr[i] == searchKey) {
                break;
            }
        }

        if (i == arr.length) {
            return -1;
        } else {
            return i;
        }
    }

    // 二分法查找
    public int binaryFind(long searchKey) {
        int ins = 0;
        int low = 0;
        int pow = elems;

        while (true) {
            ins = (low + pow) / 2;
            if (arr[ins] == searchKey) {
                return ins;
            } else if (low > pow) {
                return -1;
            } else {
                if (arr[ins] > searchKey) {
                    pow = ins - 1;
                } else {
                    low = ins + 1;
                }
            }
        }


    }

    // 删除数据
    public void delete(long deleteKey) {

        if (find(deleteKey) == -1) {
            System.out.println("查找不到指定数据，删除失败");
        } else {
            for (int i = find(deleteKey); i < elems; i++) {
                arr[i] = arr[i + 1];
            }
        }
    }

    // 修改数据
    public void change(long oddValue, long newValue) {
        if (find(oddValue) == -1) {
            System.out.println("查找不到指定数据，修改失败");
        } else {
            arr[find(oddValue)] = newValue;
        }
    }
}
