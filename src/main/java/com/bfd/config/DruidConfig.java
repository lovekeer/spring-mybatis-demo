package com.bfd.config;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *  DruidConfig
 *
 * @author jiang.liu
 * @create 2019/5/21 10:53
 * @since 1.0.0
 */
@Configuration
public class DruidConfig {
    
    @Bean
    public ServletRegistrationBean<StatViewServlet> druidServlet() {
        ServletRegistrationBean<StatViewServlet> reg = new ServletRegistrationBean<StatViewServlet>();
        reg.setServlet(new StatViewServlet());
        // 登录监控页URL http://localhost:8080/druid/login.html
        reg.addUrlMappings("/druid/*");
        // 设置登录查看信息的账号密码.
        reg.addInitParameter("loginUsername", "admin");
        reg.addInitParameter("loginPassword", "admin");
        reg.addInitParameter("logSlowSql", "true");
        reg.addInitParameter("allow", "127.0.0.1");
        return reg;
    }
    
    @Bean
    public FilterRegistrationBean<WebStatFilter> filterRegistrationBean() {
        FilterRegistrationBean<WebStatFilter> filterRegistrationBean = new FilterRegistrationBean<WebStatFilter>();
        filterRegistrationBean.setFilter(new WebStatFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        filterRegistrationBean.addInitParameter("profileEnable", "true");
        return filterRegistrationBean;
    }
    
}