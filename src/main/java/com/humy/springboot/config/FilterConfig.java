package com.humy.springboot.config;

import com.humy.springboot.filter.SecendFilter;
import com.humy.springboot.filter.URLFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther: Hu Min
 * @Date: 2018/11/5 14:22
 * @Description:
 */
@Configuration
public class FilterConfig {

//    @Bean
//    public FilterRegistrationBean setFilter1(){
//        final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
//        URLFilter filter = new URLFilter();
//
//        registrationBean.setFilter(filter);
//        registrationBean.addUrlPatterns("/*");
//        registrationBean.setOrder(1);
//        return registrationBean;
//    }
//    @Bean
//    public FilterRegistrationBean setFilter2(){
//        final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
//        SecendFilter filter = new SecendFilter();
//
//        registrationBean.setFilter(filter);
//        registrationBean.addUrlPatterns("/*");
//        registrationBean.setOrder(0);
//        return registrationBean;
//    }
}
