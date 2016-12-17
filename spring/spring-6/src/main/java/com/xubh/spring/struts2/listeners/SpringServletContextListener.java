package com.xubh.spring.struts2.listeners;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Application Lifecycle Listener implementation class SpringServletContextListener
 */
public class SpringServletContextListener implements ServletContextListener {

    /**
     * Default constructor.
     */
    public SpringServletContextListener() {
    }

    /**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent context) {
        //1. 获取 Spring 配置文件的名称.
        ServletContext servletContext = context.getServletContext();
        String config = servletContext.getInitParameter("configLocation");

        //1. 创建 IOC 容器
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);

        //2. 把 IOC 容器放在 ServletContext 的一个属性中.
        servletContext.setAttribute("ApplicationContext", ctx);
    }

    /**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0) {
    }

}
