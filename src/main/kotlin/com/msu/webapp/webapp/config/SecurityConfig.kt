package com.msu.webapp.webapp.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.web.servlet.invoke
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.util.matcher.AntPathRequestMatcher


@EnableWebSecurity
class SecurityConfig: WebSecurityConfigurerAdapter() {

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
}