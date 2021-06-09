package by.example.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class WebMvcConfigurerImpl implements WebMvcConfigurer {

    private final FirstInterceptor firstInterceptor;

    public WebMvcConfigurerImpl(FirstInterceptor firstInterceptor) {
        this.firstInterceptor = firstInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(firstInterceptor)
                .addPathPatterns("/v1/**")
                .order(1);
    }
}