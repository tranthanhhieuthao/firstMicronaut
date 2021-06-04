package com.example.Service

import com.example.model.User
import com.example.repository.UserRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserService {

    @Inject
    lateinit var userRepository: UserRepository

    fun getUserById(): List<User> {
        return userRepository.findAll().toList()
    }
}