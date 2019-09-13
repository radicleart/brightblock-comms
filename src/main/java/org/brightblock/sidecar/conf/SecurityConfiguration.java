package org.brightblock.sidecar.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http.cors().and()
    		.authorizeRequests()
			.antMatchers("/resources/**", "/v1/admin/**").permitAll()
			.anyRequest().permitAll() //.authenticated()
			.and().csrf().disable()
		.formLogin()
			.loginPage("/login").permitAll()
			.and()
		.httpBasic();
    }
    
//    @Bean
//    UrlBasedCorsConfigurationSource corsConfigurationSource() {
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
//        return source;
//    }
}
