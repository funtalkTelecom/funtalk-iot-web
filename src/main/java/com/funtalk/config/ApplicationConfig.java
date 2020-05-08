package com.funtalk.config;

import com.funtalk.config.interceptor.ReqInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration
public class ApplicationConfig extends WebMvcConfigurerAdapter{

    @Value("${app.power.exclude-path}")
    private String[] powerExcludePath;

	@Autowired private ReqInterceptor reqInterceptor;

    public void addInterceptors(InterceptorRegistry registry) {

        //APIInterceptor 暂时还没有加入
    	InterceptorRegistration ir=registry.addInterceptor(reqInterceptor)
                                    .addPathPatterns("/**")
                                    .excludePathPatterns("/","/userLogin",
                                                         "/login.jsp","/deviceState",
                                                         "/error","/api/**","/getCapcha");//拦截

        for (String value : powerExcludePath) {
            ir.excludePathPatterns(value);//排除拦截
        }

        super.addInterceptors(registry);
    }
}
