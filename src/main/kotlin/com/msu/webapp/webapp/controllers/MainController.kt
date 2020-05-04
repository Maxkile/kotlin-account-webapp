package com.msu.webapp.webapp.controllers

import com.msu.webapp.webapp.models.User
import com.msu.webapp.webapp.services.security.SecurityService
import com.msu.webapp.webapp.services.user.UserService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping

@Controller
class MainController(

        private val mainContollerLogger: Logger = LoggerFactory.getLogger(MainController::class.java),

        @Autowired
        private val userService: UserService,

        @Autowired
        private val securityService: SecurityService
){

    @GetMapping("/index")
    fun getIndex(): String{
        return "index";
    }

    @GetMapping("/registration")
    fun getRegistration(model: Model): String{
        model.addAttribute("user",User())
        return "registration";
    }

    @PostMapping("/registration")
    fun postRegistration(@ModelAttribute("user") user: User): String{
        val rawPassword = user.password
        userService.save(user)
        securityService.autoLogin(user.username,rawPassword,user.authorities);
        mainContollerLogger.info(SecurityContextHolder.getContext().authentication.principal.toString())
        return "redirect:index"
    }

    @GetMapping("/login")
    fun getLogin(model: Model, @AuthenticationPrincipal authenticatedUser: AuthenticationPrincipal?): String{
        return if (authenticatedUser == null){
            model.addAttribute("user",User())
            "login";
        }
        else{
            "redirect:index";
        }
    }

    @PostMapping("/login")
    fun postLogin(@ModelAttribute("user") user: User): String{
        securityService.autoLogin(user.username,user.password,user.authorities)
        return "redirect:index";
    }
}

