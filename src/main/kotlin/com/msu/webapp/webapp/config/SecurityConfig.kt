package com.msu.webapp.webapp.config

import com.msu.webapp.webapp.services.user.user_details.CustomUserDetailsService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.web.servlet.invoke
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.util.matcher.AntPathRequestMatcher

@Configuration
@EnableWebSecurity
class SecurityConfig(

        @Autowired
        private val userDetailService: CustomUserDetailsService,

        @Autowired
        private val bCryptPasswordEncoder: PasswordEncoder

): WebSecurityConfigurerAdapter() {


    override fun configure(auth: AuthenticationManagerBuilder) {
        auth.userDetailsService(userDetailService).passwordEncoder(bCryptPasswordEncoder)
    }

    override fun configure(http: HttpSecurity?) {
        http {
            httpBasic {}
            csrf {}
            authorizeRequests {
                authorize("/", permitAll)
                authorize("/index", permitAll)
                authorize("/registration", permitAll)
                authorize("/login",permitAll)
                authorize("/static/**", permitAll)
                authorize("/about", permitAll)
            }
            logout {
                logoutSuccessUrl = "/index"
                logoutRequestMatcher = AntPathRequestMatcher("/logout")
            }
            formLogin {
                loginPage = "/login"
            }
        }
    }

    @Bean
    @Throws(Exception::class)
    override fun authenticationManagerBean(): AuthenticationManager? = super.authenticationManagerBean()
}