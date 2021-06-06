package com.example.controller

import com.example.DTO.UserDTO
import com.example.Response.ResponseFormat
import com.example.Service.UserService
import io.micronaut.context.annotation.Parameter
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.*
import javax.inject.Inject

@Controller("/api")
class HomeController {

    @Inject
    lateinit var userService: UserService

    @Get("/hello")
    fun home(): String {
        return "hello"
    }

    @Get("/users")
    fun getUsers(@Parameter(value = "page") page: Int, @Parameter(value = "size") size: Int):  HttpResponse<ResponseFormat> {
        return HttpResponse.ok(userService.getAllUsers(page, size))
    }

    @Get("/user/{id}")
    fun getUserById(@PathVariable("id") id: Long): HttpResponse<ResponseFormat> {
        return HttpResponse.ok(userService.getDetailUser(id))
    }

    @Post("/user/update")
    fun createOrUpdate(@Body userDTO: UserDTO): HttpResponse<ResponseFormat> {
        return HttpResponse.ok(userService.createOrUpdateUser(userDTO))
    }

    @Post("/users/delete")
    fun deleteUsers(@Body listId: List<Long>): HttpResponse<ResponseFormat> {
        return HttpResponse.ok(userService.deleteUsers(listId))
    }


}