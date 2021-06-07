package com.example.controller

import com.example.DTO.UserDTO
import com.example.Response.ResponseFormat
import com.example.Service.UserService
import com.nimbusds.jose.crypto.impl.PasswordBasedCryptoProvider
import io.micronaut.context.annotation.Parameter
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.*
import io.micronaut.security.annotation.Secured
import io.micronaut.security.authentication.Authentication
import io.micronaut.security.rules.SecurityRule
import java.security.Principal
import javax.annotation.security.PermitAll
import javax.inject.Inject

@Secured(SecurityRule.IS_AUTHENTICATED)
@Controller("/api")
class HomeController {

    @Inject
    lateinit var userService: UserService

    @Get("/hello")
    @PermitAll
    fun home(): String {
        return "hello"
    }

    @Get("/admin")
    @Secured(("ADMIN"))
    fun adminAllow():  HttpResponse<ResponseFormat> {
        return HttpResponse.ok(ResponseFormat(null, ResponseFormat.MessageCode.UNAUTHORIZED.toString()))
    }

    @Get("/users")
    @Secured(("ADMIN"))
    fun getUsers(@Parameter(value = "page") page: Int, @Parameter(value = "size") size: Int):  HttpResponse<ResponseFormat> {
        return HttpResponse.ok(userService.getAllUsers(page, size))
    }

    @Get("/user/{id}")
    fun getUserById(@PathVariable("id") id: Long): HttpResponse<ResponseFormat> {
        return HttpResponse.ok(userService.getDetailUser(id))
    }

    @Post("/user/update")
    fun UpdateUser(@Body userDTO: UserDTO): HttpResponse<ResponseFormat> {
        return HttpResponse.ok(userService.UpdateUser(userDTO))
    }

    @Post("/user/create")
    @PermitAll
    fun CreateUser(@Body userDTO: UserDTO): HttpResponse<ResponseFormat> {
        return HttpResponse.ok(userService.CreateUser(userDTO))
    }

    @Post("/users/delete")
    fun deleteUsers(@Body listId: List<Long>): HttpResponse<ResponseFormat> {
        return HttpResponse.ok(userService.deleteUsers(listId))
    }


}