package com.example.model

import com.example.DTO.UserDTO
import java.util.Date
import javax.persistence.*

@Entity
@Table(name = "users")
class User (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long = -1,
        var name: String = "",
        var userName: String = "",
        var birthday: Date = Date(),
        var age: Int = 0,
        var marriage: Boolean = false,
        var password: String = "123456"

) {
        fun convertToDTO(): UserDTO {
                var userDTO: UserDTO = UserDTO()
                userDTO.age = age
                userDTO.birthday = birthday
                userDTO.marriage = marriage
                userDTO.name = name
                userDTO.password = password
                userDTO.userName = userName
                return userDTO
        }
}