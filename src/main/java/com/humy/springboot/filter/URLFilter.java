package com.humy.springboot.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Auther: Hu Min
 * @Date: 2018/11/5 14:23
 * @Description:
 */
public class URLFilter extends GenericFilter {


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        if (!FilterUtils.isInclude(request.getRequestURL().toString())) {
            System.err.println("进入第一个filter" + request.getRequestURI());
            filterChain.doFilter(servletRequest, servletResponse);
            System.err.println("filter结束");
            HttpServletResponse response = (HttpServletResponse) servletResponse;
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            String humy = response.getHeader("humy");
            System.out.println("获取的header"+humy);
            response.setHeader("第一个filter,humy", "1111111111");
        }


    }


}
