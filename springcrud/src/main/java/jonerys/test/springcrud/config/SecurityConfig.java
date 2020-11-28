package jonerys.test.springcrud.config;

import jonerys.test.springcrud.model.Permission;
import jonerys.test.springcrud.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;

    @Autowired
    public SecurityConfig(@Qualifier("CustomUserDetailsService") UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .antMatchers("/goods").hasAuthority(Permission.ADMIN_PERMISSIONS.getPermission())
                .antMatchers("/warehouses").hasAuthority(Permission.ADMIN_PERMISSIONS.getPermission())
                .antMatchers("/goods-create").hasAuthority(Permission.ADMIN_PERMISSIONS.getPermission())
                .antMatchers("/warehouses-create").hasAuthority(Permission.ADMIN_PERMISSIONS.getPermission())
                .antMatchers("/goods-update/**").hasAuthority(Permission.ADMIN_PERMISSIONS.getPermission())
                .antMatchers("/warehouses-update/**").hasAuthority(Permission.ADMIN_PERMISSIONS.getPermission())
                .antMatchers("/goods-warehouses/**").hasAuthority(Permission.USER_PERMISSIONS.getPermission())
                .antMatchers("/goods-warehouses/").hasAuthority(Permission.USER_PERMISSIONS.getPermission())
                .anyRequest().authenticated().and().formLogin();
    }

    /*@Bean
    @Override
    protected UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager us = new InMemoryUserDetailsManager();
        return new InMemoryUserDetailsManager(
                User.builder()
                        .username("admin")
                        .password(passwordEncoder().encode("admin"))
                        .authorities(Role.ADMIN.getAuthorities()).build(),
                User.builder()
                        .username("user")
                        .password(passwordEncoder().encode("user"))
                        .authorities(Role.USER.getAuthorities()).build()

        );
    }*/

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Bean
    public PasswordEncoder passwordEncoder() { return new BCryptPasswordEncoder(12); }

    @Bean
    protected DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        return daoAuthenticationProvider;
    }
}
