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
        var listUser: Page<User>
        if (page == null || size == null) listUser = userRepository.findAll(Pageable.unpaged())
        listUser = userRepository.findAll(Pageable.from(-page, size))
        listUser?.let {
            return ResponseFormat(listUser, ResponseFormat.MessageCode.SUCCESS.toString())
        }
        return ResponseFormat({}, ResponseFormat.MessageCode.NOT_EXITS.toString())
    }

    fun getDetailUser(id: Long): ResponseFormat {
        var user: User = userRepository.findById(id).get()
        user?.let {
            return ResponseFormat(user, ResponseFormat.MessageCode.SUCCESS.toString())
        }
        return ResponseFormat({}, ResponseFormat.MessageCode.NOT_EXITS.toString())
    }

    fun getUserByUserName(userName: String): ResponseFormat {
        var user: User = userRepository.getByUserName(userName)
        user?.let {
            return  ResponseFormat(user, ResponseFormat.MessageCode.SUCCESS.toString()
            )
        }
        return ResponseFormat({}, ResponseFormat.MessageCode.NOT_EXITS.toString())
    }

    fun createOrUpdateUser(userDTO: UserDTO): ResponseFormat {
        var user = getUserByUserName(userName = userDTO.userName).data as User
        user?.let {
            userRepository.save(user)
            return ResponseFormat({}, ResponseFormat.MessageCode.SUCCESS.toString() )
        }
      user = userDTO.convertToUser()
        userRepository.save(user)
        return ResponseFormat({}, ResponseFormat.MessageCode.SUCCESS.toString())
    }

    fun deleteUsers(listId: List<Long>): ResponseFormat {
        return try {
            userRepository.deleteByIdIn(listId)
            ResponseFormat({}, ResponseFormat.MessageCode.SUCCESS.toString())
        } catch (e: Exception) {
            e.stackTrace
            ResponseFormat({}, ResponseFormat.MessageCode.FAIL.toString())
        }
    }

}