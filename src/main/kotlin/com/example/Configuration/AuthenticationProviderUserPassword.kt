package com.example.Configuration

import com.example.Service.UserService
import com.example.model.User
import io.micronaut.http.HttpRequest
import io.micronaut.security.authentication.*
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.FlowableEmitter
import org.reactivestreams.Publisher
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthenticationProviderUserPassword: AuthenticationProvider {

    @Inject
    lateinit var userService: UserService

    override fun authenticate(httpRequest: HttpRequest<*>?, authenticationRequest: AuthenticationRequest<*, *>): Publisher<AuthenticationResponse> {
        return Flowable.create({ emitter: FlowableEmitter<AuthenticationResponse> ->
            var user = userService.getUserByUserName(authenticationRequest.identity as String).data
                if (user != null && authenticationRequest.secret == (user as User).password) {
                    emitter.onNext(UserDetails(authenticationRequest.identity as String, arrayListOf(user.role)))
                    emitter.onComplete()
                } else {
                    emitter.onError(AuthenticationException(AuthenticationFailed("Wrong password or Username")))
                }
        }, BackpressureStrategy.ERROR)
    }
}