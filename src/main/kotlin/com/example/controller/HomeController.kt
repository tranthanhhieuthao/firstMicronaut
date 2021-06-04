package com.example.controller

import com.example.Service.UserService
import com.example.model.User
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import javax.inject.Inject

@Controller("/api")
class HomeController {

    @Inject
    lateinit var userService: UserService

    @Get("/home")
    fun home(): String {
        return "hello"
    }

    @Get("/users")
    fun getUser() :List<User> {
        return userService.getUserById()
    }
}