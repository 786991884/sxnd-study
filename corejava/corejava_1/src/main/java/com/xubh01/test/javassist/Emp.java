package com.xubh01.test.javassist;


@com.xubh01.test.Author(name = "gaoqi", year = 2014)
public class Emp {

    private int empno;
    private String ename;

    public void sayHello(int a) {
        System.out.println("sayHello," + a);
    }

    public int getEmpno() {
        return empno;
    }

    public void setEmpno(int empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public Emp(int empno, String ename) {
        super();
        this.empno = empno;
        this.ename = ename;
    }

    public Emp() {
    }
}
