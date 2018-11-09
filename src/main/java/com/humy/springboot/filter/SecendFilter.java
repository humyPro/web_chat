package com.humy.springboot.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @Auther: Hu Min
 * @Date: 2018/11/5 15:27
 * @Description:
 */

public class SecendFilter extends GenericFilter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        if (!FilterUtils.isInclude(request.getRequestURL().toString())) {

            System.out.println("第二个filter");
            filterChain.doFilter(servletRequest, servletResponse);
            System.out.println("走出第二个filter");
        }
    }
}
