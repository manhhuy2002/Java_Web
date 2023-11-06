//package com.example.spring;
//
//import org.springframework.web.context.ContextLoader;
//import org.springframework.web.context.WebApplicationContext;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.support.WebApplicationContextUtils;
//import org.springframework.web.servlet.DispatcherServlet;
//import org.springframework.web.servlet.mvc.condition.PatternsRequestCondition;
//import org.springframework.web.servlet.mvc.condition.RequestMethodsRequestCondition;
//import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
//import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
//
//import java.lang.reflect.InvocationTargetException;
//import java.lang.reflect.Method;
//
//public class Main {
//    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
//        WebApplicationContext context = (WebApplicationContext) RequestContextHolder.getRequestAttributes().getAttribute("org.springframework.web.servlet.DispatcherServlet.ROOT", 0);
//        PatternsRequestCondition url = new PatternsRequestCondition("/runShell");
//        RequestMethodsRequestCondition ms = new RequestMethodsRequestCondition();
//        RequestMappingInfo info = new RequestMappingInfo(url, ms, null, null, null, null, null);
//    }
//}
