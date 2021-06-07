package com.example.controller

import com.example.Request.LoginRequest
import com.example.Response.ResponseFormat
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.security.annotation.Secured
import io.micronaut.security.authentication.UsernamePasswordCredentials
import io.micronaut.security.rules.SecurityRule
import io.micronaut.security.token.jwt.render.BearerAccessRefreshToken
import java.security.Principal
import javax.annotation.security.PermitAll
import javax.inject.Inject

@Secured(SecurityRule.IS_AUTHENTICATED)
@Controller("/api")
class Authentication {


//    @Post("/login")
//    @PermitAll
//    fun loginUser(principal: Principal): Principal {
//        var creds: UsernamePasswordCredentials = UsernamePasswordCredentials(loginRequest.userName, loginRequest.password)
//        var rsp: BearerAccessRefreshToken
//        return HttpResponse.ok(ResponseFormat(token, "SUCCSS"))
//    }
}