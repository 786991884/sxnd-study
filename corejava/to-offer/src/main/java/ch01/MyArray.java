package ch01;

public class MyArray {
    // 数组
    private long[] arr;

    // 数组中有效数据的大小
    private int elems;

    //默认构造函数
    public MyArray() {
        arr = new long[50];
    }

    public MyArray(int max) {
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
