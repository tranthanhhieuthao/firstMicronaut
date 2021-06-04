package com.example.controller

import com.example.Response.ResponseFormat
import com.example.Service.UserService
import com.example.model.User
import io.micronaut.context.annotation.Parameter
import io.micronaut.data.model.Page
import io.micronaut.http.HttpResponse
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
    fun getUser(@Parameter("page") page: Int, @Parameter("size")size: Int) :  ResponseFormat {
        return userService.getAllUsers(page, size)
    }

    @Get("/user/{id}")
    fun getUserById(@PathVariable("id") id: Long): HttpResponse<ResponseFormat> {
        return HttpResponse.ok(userService.getDetailUser(id))
    }


}