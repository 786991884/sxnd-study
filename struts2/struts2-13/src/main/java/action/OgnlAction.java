package action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.ParameterAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import bean.Address;
import bean.Person;

import com.opensymphony.xwork2.Action;

public class OgnlAction implements Action, ParameterAware, SessionAware,
		RequestAware, ApplicationAware {
	private Map paramters;
	private Map request;
	private Map session;
	private Map application;
	private List<Person> persons = new ArrayList<>();

	public List<Person> getPersons() {
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

	@Override
	public String execute() throws Exception {
		System.out.println("OgnlAction Run...");
		// 在parameters中添加欢迎信息
		paramters.put("welcome", "welcome!");
		// org.apache.struts2.dispatcher.FilterDispatcher
		// 在request对象中添加person对象
		Address ad1 = new Address("中国", "北京", "AA路");
		Map<String, String> map1 = new HashMap<String, String>();
		map1.put("card1", "0001");
		map1.put("card2", "0002");
		map1.put("card3", "0003");
		Person p1 = new Person("张三", 20, ad1, map1);
		request.put("person", p1.getName());
		// 在session中添加person对象
		Address ad2 = new Address("中国", "天津", "BB路");
		Map<String, String> map2 = new HashMap<String, String>();
		map2.put("card1", "0010");
		map2.put("card2", "0011");
		map2.put("card3", "0012");
		Person p2 = new Person("李四", 23, ad2, map2);
		session.put("person", p2.getName());

		// 在application中添加person对象
		Address ad3 = new Address("中国", "上海", "CC路");
		Map<String, String> map3 = new HashMap<String, String>();
		map3.put("card1", "0020");
		map3.put("card2", "0021");
		map3.put("card3", "0022");
		Person p3 = new Person("王五", 30, ad3, map3);
		application.put("person", p3.getName());
		persons.add(p1);
		persons.add(p2);
		persons.add(p3);
		return SUCCESS;
	}

	@Override
	public void setApplication(Map<String, Object> application) {
		this.application = application;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	@Override
	public void setParameters(Map<String, String[]> parameters) {
		this.paramters = parameters;
	}

	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}

}
