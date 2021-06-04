package com.example.repository

import com.example.model.User
import io.micronaut.context.annotation.Executable
import io.micronaut.data.annotation.Repository
import io.micronaut.data.model.Page
import io.micronaut.data.model.Pageable
import io.micronaut.data.repository.CrudRepository

@Repository
interface UserRepository: CrudRepository<User, Long>{

    @Executable
    fun findAll(pageable: Pageable): Page<User>

    @Executable
    fun getByUserName(userName: String): User

    @Executable
    fun deleteByIdIn(listId: List<Long>)
}