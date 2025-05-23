package org.infy.UserServiceApplication.configuration;

import org.infy.UserServiceApplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {

    @Autowired
    UserService userService;

    @Autowired
    CommonConfig commonConfig;

    @Value("${user.authority}")
    private String userAuthority;

    @Value("${admin.authority}")
    private String adminAuthority;

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userService);
        authenticationProvider.setPasswordEncoder(commonConfig.getEncoder());
        return authenticationProvider;
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/user/addUpdate/**").permitAll()
//                        .requestMatchers("/user/addAdmin/**").permitAll()
//                        .requestMatchers("/user/filter/**").hasAnyAuthority(adminAuthority,studentAuthority)
//                        .requestMatchers("/txn/create/**").hasAuthority(adminAuthority)
//                        .requestMatchers("/txn/return/**").hasAuthority(adminAuthority)
//                        .requestMatchers("/book/addBook/**").hasAuthority(adminAuthority)
//                        .requestMatchers("/book/filter/**").hasAnyAuthority(adminAuthority,studentAuthority)
                        .anyRequest().permitAll()
                ).formLogin(withDefaults()).httpBasic(withDefaults()).csrf(csrf -> csrf.disable());
        return http.build();
    }
}
