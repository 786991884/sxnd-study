package com.xubh.struts2.app;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.xubh.struts2.model.Department;

public class TestComplextPropertyAction extends ActionSupport implements ModelDriven<Department> {

    private static final long serialVersionUID = 1L;

    @Override
    public String execute() throws Exception {
        System.out.println(department);
        return SUCCESS;
    }

    private Department department;

    @Override
    public Department getModel() {
        department = new Department();
        return department;
    }

}
