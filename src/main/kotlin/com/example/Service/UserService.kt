package com.example.Service

import com.example.DTO.UserDTO
import com.example.Response.ResponseFormat
import com.example.model.User
import com.example.repository.UserRepository
import io.micronaut.data.model.Page
import io.micronaut.data.model.Pageable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserService {

    @Inject
    lateinit var userRepository: UserRepository

    fun getAllUsers(page: Int, size: Int): ResponseFormat {
        page ?: 1
        size ?: 10
        var listUser: Page<User> = userRepository.findAll(Pageable.from(-page, size))
        listUser?.let {
            return ResponseFormat(listUser, ResponseFormat.MessageCode.SUCCESS.toString())
        }
        return ResponseFormat(null, ResponseFormat.MessageCode.NOT_EXITS.toString())
    }

    fun getDetailUser(id: Long): ResponseFormat {
        var user: User = userRepository.findById(id).get()
        user?.let {
            return ResponseFormat(user, ResponseFormat.MessageCode.SUCCESS.toString())
        }
        return ResponseFormat(null, ResponseFormat.MessageCode.NOT_EXITS.toString())
    }

    fun getUserByUserName(userName: String): ResponseFormat {
        var user: User
        try {
             user = userRepository.getByUserName(userName)
        } catch (e: Exception) {
            return ResponseFormat(null, ResponseFormat.MessageCode.NOT_EXITS.toString())
        }

        user?.let {
            return  ResponseFormat(user, ResponseFormat.MessageCode.SUCCESS.toString()
            )
        }
        return ResponseFormat(null, ResponseFormat.MessageCode.NOT_EXITS.toString())
    }

    fun createOrUpdateUser(userDTO: UserDTO): ResponseFormat {
        var user = getUserByUserName(userName = userDTO.userName).data
        user?.let {
            userRepository.update(userDTO.convertToUserByInstance(it as User))
            return ResponseFormat(null, ResponseFormat.MessageCode.SUCCESS.toString() )
        }
        user = userDTO.convertToUser()
        userRepository.save(user)
        return ResponseFormat(null, ResponseFormat.MessageCode.SUCCESS.toString())
    }

    fun deleteUsers(listId: List<Long>): ResponseFormat {
        return try {
            userRepository.deleteByIdIn(listId)
            ResponseFormat(null, ResponseFormat.MessageCode.SUCCESS.toString())
        } catch (e: Exception) {
            e.stackTrace
            ResponseFormat(null, ResponseFormat.MessageCode.FAIL.toString())
        }
    }

}