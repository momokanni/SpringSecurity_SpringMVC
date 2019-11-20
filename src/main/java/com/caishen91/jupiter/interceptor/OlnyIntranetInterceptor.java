package com.caishen91.jupiter.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by zhanghui on 16-9-18
 */
public class OlnyIntranetInterceptor implements HandlerInterceptor {
    private Logger logger = LoggerFactory.getLogger(OlnyIntranetInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(handler instanceof HandlerMethod){
            HandlerMethod method = (HandlerMethod)handler;
            OlnyIntranet onlyIntranet = method.getMethodAnnotation(OlnyIntranet.class);

            if(onlyIntranet != null){
               String addr = request.getRemoteAddr();
                if (!(addr.startsWith("192.") || addr.startsWith("127."))) {
                    response.sendError(403,"非法请求");
                    logger.error("IP:" + addr + " 非法请求" + method.getBeanType() + "." + method.getMethod().getName() + "()");
                    return false;
                }
            }
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
