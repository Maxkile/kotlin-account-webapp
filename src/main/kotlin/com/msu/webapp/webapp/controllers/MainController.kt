package com.msu.webapp.webapp.controllers

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class MainController{

    @GetMapping("/index")
    fun getIndex() : String{
        return "index";
    }

    @GetMapping("/")
    fun getIndexDup() : String{
        return "index";
    }

    @GetMapping("/login")
    fun getLogin() : String{
        return "login";
    }
}

