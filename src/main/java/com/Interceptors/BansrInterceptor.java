package com.Interceptors;

import org.springframework.context.ApplicationContext;
import org.springframework.lang.Nullable;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.applet.AppletContext;
import com.service.*;
import com.entity.*;
import java.util.*;

//测试用的    基本拦截器     必须有HandlerInterceptor
public class BansrInterceptor implements HandlerInterceptor{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("-------------------进入controller");

            IDemoService ds = (IDemoService)(getBean("demoService",request.getServletContext()));
            System.out.println("demoService ="+ds);
        return true;
    }
    //建立私有的方法
    private Object getBean(String name, ServletContext cts)throws Exception{
        //在无法注入的情况下，如何取得 spring   上下文
        ApplicationContext ct = WebApplicationContextUtils.getRequiredWebApplicationContext(cts);
        return ct.getBean(name);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        System.out.println("-------------------出controller");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        //view   相当于  jsp
        System.out.println("-------------------进入 view");
    }
}
