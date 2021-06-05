package com.example.controller

import com.example.DTO.UserDTO
import com.example.Response.ResponseFormat
import com.example.Service.UserService
import com.example.model.User
import io.micronaut.context.annotation.Parameter
import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.*
import java.util.*
import javax.inject.Inject

@Controller("/api")
class HomeController {

    @Inject
    lateinit var userService: UserService

    @Get("/home")
    fun home(): String {
        return "hello"
    }

    @Get("/user")
    fun getUser(@Parameter page: Int, @Parameter size: Int):  HttpResponse<ResponseFormat> {
        return HttpResponse.ok(userService.getAllUsers(page, size))
    }

    @Get("/user/{id}")
    fun getUserById(@PathVariable("id") id: Long): HttpResponse<ResponseFormat> {
        return HttpResponse.ok(userService.getDetailUser(id))
    }

    @Put("/user/update")
    fun createOrUpdate(@Body userDTO: UserDTO): HttpResponse<ResponseFormat> {
        return HttpResponse.ok(userService.createOrUpdateUser(userDTO))
    }


}