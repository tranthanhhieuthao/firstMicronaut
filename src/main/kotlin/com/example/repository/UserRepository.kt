package com.example.repository

import com.example.model.User
import io.micronaut.context.annotation.Executable
import io.micronaut.data.annotation.Query
import io.micronaut.data.annotation.Repository
import io.micronaut.data.model.Page
import io.micronaut.data.model.Pageable
import io.micronaut.data.repository.CrudRepository

@Repository
interface UserRepository: CrudRepository<User, Long>{

    fun findAll(pageable: Pageable): Page<User>

    @Query(value = "SELECT * FROM users WHERE :username LIKE '%user_name%'", nativeQuery = true)
    fun getByUserName(userName: String): User

    fun deleteByIdIn(listId: List<Long>)
}