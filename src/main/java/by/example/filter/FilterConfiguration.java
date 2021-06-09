package by.example.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;

@Configuration
public class FilterConfiguration {

    @Bean
    public FilterRegistrationBean<FirstFilter> firstFilterRegistrationBean(@Autowired FirstFilter firstFilter) {
        FilterRegistrationBean<FirstFilter> registrationBean = new FilterRegistrationBean<>(firstFilter);
        registrationBean.setEnabled(true); // default = true
        registrationBean.setOrder(Ordered.HIGHEST_PRECEDENCE); // default = Integer.MAX_VALUE
        registrationBean.addUrlPatterns("/v1/*"); // default = '/*'
        return registrationBean;
    }
}
