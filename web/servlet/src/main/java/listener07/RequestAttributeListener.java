package listener07;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.annotation.WebListener;

public class RequestAttributeListener implements
		ServletRequestAttributeListener {

	public RequestAttributeListener() {
	}

	/**
	 * @see ServletRequestAttributeListener#attributeAdded(ServletRequestAttributeEvent)
	 */
	public void attributeAdded(ServletRequestAttributeEvent srae) {
		System.out.println("request attribute added,attribute="
				+ srae.getName() + ",value" + srae.getValue());
	}

	/**
	 * @see ServletRequestAttributeListener#attributeRemoved(ServletRequestAttributeEvent)
	 */
	public void attributeRemoved(ServletRequestAttributeEvent srae) {
		System.out.println("request attribute removed, attribute="
				+ srae.getName() + ",value=" + srae.getValue());
	}

	/**
	 * @see ServletRequestAttributeListener#attributeReplaced(ServletRequestAttributeEvent)
	 */
	public void attributeReplaced(ServletRequestAttributeEvent srae) {
		System.out.println("request attribute replaced, attribute="
				+ srae.getName() + ",value=" + srae.getValue());
	}

}
