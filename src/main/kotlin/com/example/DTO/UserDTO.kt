package com.example.DTO

import com.example.model.User
import java.util.*

data class UserDTO(
    var name: String = "",
    var userName: String = "",
    var birthday: Date = Date(),
    var age: Int = 0,
    var marriage: Boolean = false,
    var password: String = "123456"
) {
    fun convertToUser(): User {
        var user: User = User()
        user.age = age
        user.birthday = birthday
        user.marriage = marriage
        user.name = name
        user.password = password
        user.userName = userName
        return user
    }
}
