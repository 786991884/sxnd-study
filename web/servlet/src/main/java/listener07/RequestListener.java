package listener07;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class RequestListener
 * 
 */
@WebListener
public class RequestListener implements ServletRequestListener {
	int count = 0;

	/**
	 * @see ServletRequestListener#requestDestroyed(ServletRequestEvent)
	 */
	public void requestDestroyed(ServletRequestEvent sre) {
		count--;
		System.out.println("request Destroyed,count=" + count + ",IP="
				+ sre.getServletRequest().getRemoteAddr());
	}

	/**
	 * @see ServletRequestListener#requestInitialized(ServletRequestEvent)
	 */
	public void requestInitialized(ServletRequestEvent sre) {
		count++;
		System.out.println("request initialized,count=" + count + ",IP="
				+ sre.getServletRequest().getRemoteAddr());
	}

}
