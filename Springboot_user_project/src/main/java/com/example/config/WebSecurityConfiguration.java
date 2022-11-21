package com.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.example.service.impl.UserMasterServceImpl;

public class WebSecurityConfiguration extends WebMvcConfigurerAdapter {
	
	@Autowired
	private UserMasterServceImpl userMasterServceImpl ;
	
	@Bean
	AuthenticationProvider authenticationProvider () {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(new BCryptPasswordEncoder());
		return provider;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.authorizeRequests()
		.antMatchers("/", "/register", "/search/**", "/delete/**").permitAll()
		.antMatchers("/login").hasAuthority("User")
		.anyRequest()
		.authenticated()
		.and()
		.httpBasic();
	} 
	
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userMasterService(userMasterServceImpl)
                .passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
	
	
}

}
