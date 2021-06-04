package com.example.repository

import com.example.model.User
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository

@Repository
interface UserRepository: CrudRepository<User, Long>{
}