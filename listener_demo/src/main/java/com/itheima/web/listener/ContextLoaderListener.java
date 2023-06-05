package com.itheima.web.listener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @author Mendy
 * @create 2023-06-05 19:38
 */
@WebListener
public class ContextLoaderListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("ContextLoaderListener ..........");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
