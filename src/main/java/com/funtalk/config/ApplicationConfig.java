package com.funtalk.config;

import com.funtalk.config.interceptor.APIInterceptor;
import com.funtalk.config.interceptor.ReqInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration
public class ApplicationConfig extends WebMvcConfigurerAdapter{

    @Value("${app.power.exclude-path}")
    private String[] powerExcludePath;

	@Autowired private ReqInterceptor reqInterceptor;
    @Autowired private APIInterceptor apiInterceptor;

    public void addInterceptors(InterceptorRegistry registry) {

    	InterceptorRegistration ir=registry.addInterceptor(reqInterceptor)
                                    .addPathPatterns("/**")
                                    .excludePathPatterns("/","/userLogin",
                                                         "/login.jsp","/deviceState",
                                                         "/error","/api/**","/getCapcha");//拦截

        for (String value : powerExcludePath) {
            ir.excludePathPatterns(value);//排除拦截
        }

        ir=registry.addInterceptor(apiInterceptor).addPathPatterns("/api/**");//拦截
        for (String value : powerExcludePath) {
            ir.excludePathPatterns(value);//排除拦截
        }

        super.addInterceptors(registry);

    }


    @Bean
    public EmbeddedServletContainerCustomizer containerCustomizer() {
        return new EmbeddedServletContainerCustomizer() {
            public void customize(ConfigurableEmbeddedServletContainer container) {

                ErrorPage error401Page = new ErrorPage(HttpStatus.UNAUTHORIZED, "/401.html");
                ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/404.html");
                ErrorPage error500Page = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/500.html");

                container.addErrorPages(error401Page, error404Page, error500Page);
            }
        };
    }
}
