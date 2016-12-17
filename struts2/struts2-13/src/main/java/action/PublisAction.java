package action;

import com.opensymphony.xwork2.ActionSupport;

public class PublisAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private String content;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String execute() throws Exception {
		System.out.println(content);
		return SUCCESS;
	}
}
