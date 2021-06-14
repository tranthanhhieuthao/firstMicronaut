package com.example.model

import com.example.DTO.UserDTO
import java.util.Date
import javax.persistence.*

@Entity
@Table(name = "users")
class User (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = null,
        var name: String? = null,
        var userName: String? = null,
        var birthday: Date? = null,
        var age: Int? = null,
        var marriage: Boolean = false,
        var password: String? = null,
        var role: String = "USER"

) {
        fun convertToDTO(): UserDTO {
                var userDTO: UserDTO = UserDTO()
                userDTO.age = age
                userDTO.birthday = birthday
                userDTO.marriage = marriage
                userDTO.name = name
                userDTO.password = password
                userDTO.userName = userName
                userDTO.role = role
                return userDTO
        }
}