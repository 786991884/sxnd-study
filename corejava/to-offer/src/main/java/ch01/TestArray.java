package ch01;

public class TestArray {

    public static void main(String[] args) {
        //创建数组
        int[] myArray = new int[30];
        int[] myArray2;
        myArray2 = new int[10];

        //访问数组数据项
        myArray2[0] = 12;

        //数组初始化
        boolean[] booleanArr = new boolean[10];
        byte[] byteArr = new byte[10];
        char[] charArr = new char[10];
        short[] shortArr = new short[10];
        int[] intArr = new int[10];
        long[] longArr = new long[10];
        float[] floatArr = new float[10];
        double[] doubleArr = new double[10];

        System.out.println(booleanArr[0]);
        System.out.println(byteArr[0]);
        System.out.println(charArr[0]);
        System.out.println(shortArr[0]);
        System.out.println(intArr[0]);
        System.out.println(longArr[0]);
        System.out.println(floatArr[0]);
        System.out.println(doubleArr[0]);

        //显示的初始化
        int[] intArray2 = {1, 2, 3, 4, 5, 6};

    }

}
