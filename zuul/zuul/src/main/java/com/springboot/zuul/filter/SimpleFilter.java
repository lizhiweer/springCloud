package com.springboot.zuul.filter;

import javax.servlet.http.HttpServletRequest;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

//交由spring容器管理
@Component
public class SimpleFilter extends ZuulFilter {
    private static Logger log = LoggerFactory.getLogger(SimpleFilter.class);

    //包含决定是否执行此筛选器的逻辑(此方法将始终执行)
    @Override
    public boolean shouldFilter() {
        return true;
    }

    //过滤器的任务
    @Override
    public Object run() throws ZuulException {
        //Zuul过滤器将请求和状态信息存储在RequestContext中(并通过RequestContext共享)。
        //我们使用它来获取HttpServletRequest，然后在请求发送之前记录它的HTTP方法和URL。
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        log.info("前置过滤器执行 "+String.format("%s request to %s",
             request.getMethod(), request.getRequestURI()));
        return null;
    }

    //返回代表过滤器类型的字符串
    @Override
    public String filterType() {
        return "pre";
    }

    
    //给出此过滤器相对于其他过滤器执行的顺序 
    @Override
    public int filterOrder() {
        return 1;
    }



}

