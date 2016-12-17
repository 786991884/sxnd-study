package action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class CalcAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private int num;

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	// 处理第一个逻辑
	@Override
	public String execute() throws Exception {
		return "done";
	}

	// 处理第二个逻辑
	public String calc() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("num", this.getNum());
		return "done";
	}
}
