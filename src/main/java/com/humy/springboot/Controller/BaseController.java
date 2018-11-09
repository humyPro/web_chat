package com.humy.springboot.Controller;

import com.humy.springboot.pojo.ResultVo;
import com.sun.javafx.binding.StringFormatter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Auther: Hu Min
 * @Date: 2018/11/5 13:57
 * @Description:
 */
@RestController
@RequestMapping("/")
public class BaseController {
    @GetMapping("/hello")
    public String hello(HttpServletRequest request,HttpServletResponse response) {
        String url = request.getRequestURL().toString();
        String contextPath = request.getContextPath();
        System.out.println("contextPath is"+contextPath);
        String host = request.getRemoteHost();
        System.out.println("RemoteHost is " +host);

        String ip  =  request.getHeader( " x-forwarded-for " );
        if (ip  ==   null   ||  ip.length()  ==   0   ||   " unknown " .equalsIgnoreCase(ip))  {
            ip  =  request.getHeader( " Proxy-Client-IP " );
        }
        if (ip  ==   null   ||  ip.length()  ==   0   ||   " unknown " .equalsIgnoreCase(ip))  {
            ip  =  request.getHeader( " WL-Proxy-Client-IP " );
        }
        if (ip  ==   null   ||  ip.length()  ==   0   ||   " unknown " .equalsIgnoreCase(ip))  {
            ip  =  request.getRemoteAddr();
        }
        response.setHeader("humy", "hahahhahaha");
        System.out.printf("hello, your url is %s and your addr is %s\n", url, ip);

        return "访问成功";
    }
    @GetMapping("/getmethod")
    public ResultVo getMethod(@RequestParam String name){
        System.out.println(name+"请求成功");
        return new ResultVo(name, "返回的数据:请求成功");
    }


}
