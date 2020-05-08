package com.funtalk.config.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ApplicationListener  implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

        ServletContext  sc=servletContextEvent.getServletContext();
        String contextPath=sc.getContextPath();

        sc.setAttribute("cpath",contextPath);

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
