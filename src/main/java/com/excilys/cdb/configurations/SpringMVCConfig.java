package com.excilys.cdb.configurations;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

public class SpringMVCConfig implements WebMvcConfigurer{
	

	@Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
	
	 @Bean
	 public ReloadableResourceBundleMessageSource messageSource() {
		 ReloadableResourceBundleMessageSource ret = new ReloadableResourceBundleMessageSource();
		 ret.setBasename("classpath:messages");
		 ret.setDefaultEncoding("utf-8");
		 return ret;
	 }
	 
	 @Bean
	 public CookieLocaleResolver localeResolver(){
	    CookieLocaleResolver resolver = new CookieLocaleResolver();
	    resolver.setDefaultLocale(Locale.ENGLISH);
	    resolver.setCookieName("locale");
	    resolver.setCookieMaxAge(3600);
	    return resolver;
	 }
	 
	 @Bean
	 public LocaleChangeInterceptor localeChangeInterceptor() {
		 LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
	     localeChangeInterceptor.setParamName("dashboard");
	     return localeChangeInterceptor;
	 }
	 
	 @Override
	 public void addInterceptors(InterceptorRegistry registry) {
		 registry.addInterceptor(localeChangeInterceptor());
	 }

}
