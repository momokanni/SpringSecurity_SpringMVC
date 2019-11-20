package com.caishen91.jupiter.interceptor;

import com.caishen91.jupiter.model.SysUser;
import com.caishen91.jupiter.util.LoginUtil;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Auther: jgn
 * @Date: 2/25/19 11 19
 * Description:
 */
public class ManagerLoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        SysUser user = LoginUtil.getSysLoginUser(request, response);
        if (user == null) {
            String scheme = "http";
            Boolean ssl = (Boolean)request.getAttribute("ssl");
            if (ssl != null && ssl) {
                scheme = "https";
            }
            String prefix = scheme + "://" + request.getServerName() + (request.getServerPort() == 80 ? "" : ":" + request.getServerPort());

            response.sendRedirect(prefix + "/manager/login.jsp");
            return false;
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
