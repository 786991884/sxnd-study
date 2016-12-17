package com.xubh01.test.vo;

public class EmpVO {
    //	e.id,e.empname,e.age,d.dname 'deptName',d.address 'deptAddr'
    private Integer id;
    private String empname;
    private Integer age;
    private String deptName;
    private String deptAddr;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptAddr() {
        return deptAddr;
    }

    public void setDeptAddr(String deptAddr) {
        this.deptAddr = deptAddr;
    }

    public EmpVO(Integer id, String empname, Integer age, String deptName,
                 String deptAddr) {
        super();
        this.id = id;
        this.empname = empname;
        this.age = age;
        this.deptName = deptName;
        this.deptAddr = deptAddr;
    }

    public EmpVO() {
    }

}
