package ecom.config;

import ecom.security.CustomAuthenticationSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig {
    private final CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Autowired
    public AppSecurityConfig(CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler) {
        this.customAuthenticationSuccessHandler = customAuthenticationSuccessHandler;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        //httpSecurity
                /*
                .authorizeRequests()
                .antMatchers("/users/**")
                .access("hasRole('ROLE_ADMIN')")
                .antMatchers("/users/**")
                .access("hasRole('ROLE_USER')")
                .antMatchers("/books/**")
                .access("hasRole('ROLE_USER')")
                .antMatchers("/vendors/**")
                .access("hasRole('ROLE_USER')")
                .antMatchers("/students/**")
                .access("hasRole('ROLE_USER')")
                .and()
                .formLogin()
                .loginPage("/users/sign-in")
                //.successHandler((request, response, authentication) -> )
                .permitAll()
                .and()
                //.rememberMe()
                //.and()
                .logout()
                .permitAll();
                 */

        return httpSecurity.build();
    }
}
