package com.wq.web.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.wq.dao.StudentDao;
import com.wq.vo.PageBean;
import com.wq.vo.Student;

public class TableAction extends ActionSupport {
	private List<Student> gridModel;
	private Integer rows = 10;
	private Integer page = 1;
	private Integer total = 0;
	private Integer records = 0;

	public List<Student> getGridModel() {
		return gridModel;
	}

	public void setGridModel(List<Student> gridModel) {
		this.gridModel = gridModel;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getRecords() {
		return records;
	}

	public void setRecords(Integer records) {
		this.records = records;
	}

	@Override
	public String execute() throws Exception {
		StudentDao sdao = new StudentDao();
		PageBean pb = sdao.getPageBean(page, rows);
		total = pb.getTotalPage();
		records = pb.getTotal();
		gridModel = pb.getData();
		return SUCCESS;
	}
}
