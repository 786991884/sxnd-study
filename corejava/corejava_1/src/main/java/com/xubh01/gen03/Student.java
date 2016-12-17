package com.xubh01.gen03;

/**
 * 泛型的擦除
 * 1、继承|实现声明 不指定类型
 * 2、使用时 不指定类型
 * 统一Object 对待
 * 1、编译器警告 消除使用Object
 * 2、不完全等同于Object ,编译不会类型检查
 *
 * @param <T>
 */
public class Student<T> {
    private T javaScore;
    private T oracleScore;

    //泛型声明时不能使用 静态属性|静态方法上
    //private static T1 test;


    public T getJavaScore() {
        return javaScore;
    }


    public void setJavaScore(T javaScore) {
        this.javaScore = javaScore;
    }


    public T getOracleScore() {
        return oracleScore;
    }


    public void setOracleScore(T oracleScore) {
        this.oracleScore = oracleScore;
    }

    public static void main(String[] args) {
        Student stu1 = new Student();
        //消除警告 使用 Object
        Student<Object> stu = new Student<Object>();
        //stu.setJavaScore("af"); //以Object对待

        test(stu1); //stu1 相当于Object 但是不完全等同Object
        //擦除，不会类型检查
        //test(stu);
        test1(stu1);
        test1(stu);

    }

    public static void test(Student<Integer> a) {

    }

    public static void test1(Student<?> a) {

    }
}
