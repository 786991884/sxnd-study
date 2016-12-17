package interceptor;

import java.util.Map;

import action.PublisAction;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class PublisInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		Object object = invocation.getAction();
		System.out.println(object);
		if (object instanceof PublisAction) {
			PublisAction publisAction = (PublisAction) object;
			/*
			 * String content = publisAction.getContent();
			 * System.out.println(content);
			 */
			Map paramMap = invocation.getInvocationContext().getParameters();
			String[] contents = (String[]) paramMap.get("content");
			String content = contents[0];
			System.out.println("content=" + content);
			publisAction.setContent(content.replaceAll("敏感字", "***"));
			// publisAction.setContent(content.replace("hehe", "***"));
			return invocation.invoke();
		} else {
			return "publis";
		}
	}

}
