package oracle.wdp.struts2.action;

import oracle.wdp.struts2.exception.SecurityBreachException;

import com.opensymphony.xwork2.ActionSupport;

public class ExceptionAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String causeException() throws Exception {
		throw new Exception();
	}

	public String causeNullException() throws NullPointerException {
		throw new NullPointerException();
	}

	public String causeSecuriException() throws SecurityBreachException {
		throw new SecurityBreachException();
	}
}
