package ch01;

public class TestArray2 {
    public static void main(String[] args) {
        int[] intArray = new int[10];

        // 插入数据
        intArray[0] = 1;
        intArray[1] = 2;

        // 循环插入数据
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = i;
        }

        // 显示数据
        for (int i = 0; i < intArray.length; i++) {
            System.out.print(intArray[i] + " ");
        }

        System.out.println();

        // 查找数据
        int searchKey = 5;
        int i;
        for (i = 0; i < intArray.length; i++) {
            if (intArray[i] == searchKey) {
                break;
            }
        }

        if (i == intArray.length) {
            System.out.println("查找不到指定数据");
        } else {
            System.out.println("找到指定数据，下标为" + i);
        }

        // 删除数据
        int deleteKey = 4;
        for (i = 0; i < intArray.length; i++) {
            if (intArray[i] == deleteKey) {
                break;
            }
        }

        if (i == intArray.length) {
            System.out.println("查找不到指定数据");
        } else {
            for (int j = i; j < intArray.length - 1; j++) {
                intArray[j] = intArray[j + 1];
            }
            intArray[intArray.length - 1] = 0;
        }

        // 显示数据
        for (int a = 0; a < intArray.length; a++) {
            System.out.print(intArray[a] + " ");
        }

        // 修改数据
        int xiugaiKey = 5;
        for (i = 0; i < intArray.length; i++) {
            if (intArray[i] == xiugaiKey) {
                break;
            }
        }

        if (i == intArray.length) {
            System.out.println("查找不到指定数据");
        } else {
            intArray[i] = 6;
        }


        System.out.println();
        // 显示数据
        for (int a = 0; a < intArray.length; a++) {
            System.out.print(intArray[a] + " ");
        }
    }

}
