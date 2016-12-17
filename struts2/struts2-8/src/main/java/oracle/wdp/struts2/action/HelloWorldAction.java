package oracle.wdp.struts2.action;

import oracle.wdp.struts2.model.MessageStore;

import com.opensymphony.xwork2.ActionSupport;

public class HelloWorldAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private MessageStore messageStore;
	// 由于每次请求一个action实例，加大同要记录action的访问次数，必须是static的
	private static int helloCount = 0;

	@Override
	public String toString() {
		return messageStore + "(from toString)";
	}

	public HelloWorldAction() {
		System.out.println(22);
	}

	@Override
	public String execute() throws Exception {
		messageStore = new MessageStore();
		helloCount++;
		return SUCCESS;
	}

	public MessageStore getMessageStore() {
		return messageStore;
	}

	public void setMessageStore(MessageStore messageStore) {
		this.messageStore = messageStore;
	}

	public int getHelloCount() {
		return helloCount;
	}

	public void setHelloCount(int helloCount) {
		HelloWorldAction.helloCount = helloCount;
	}
}
