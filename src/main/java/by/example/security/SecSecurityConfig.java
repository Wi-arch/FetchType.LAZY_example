package by.example.security;

import by.example.filter.FirstFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AnonymousAuthenticationFilter;

@EnableWebSecurity(debug = true)
public class SecSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/v1/**").authenticated()
                .and()
                .formLogin();

        http.addFilterBefore(firstFilter(), AnonymousAuthenticationFilter.class);
    }

    @Bean
    public FirstFilter firstFilter() {
        return new FirstFilter();
    }
}
