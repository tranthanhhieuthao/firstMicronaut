package com.example.DTO

import com.example.model.User
import java.util.Date

data class UserDTO(
    var name: String? = null,
    var userName: String? = null,
    var birthday: Date? = null,
    var age: Int? = null,
    var marriage: Boolean = false,
    var password: String? = null,
    var role:String = "USER"
) {
    fun convertToUser(): User {
        var user: User = User()
        user.age = age
        user.birthday = birthday
        user.marriage = marriage
        user.name = name
        user.password = password
        user.userName = userName
        user.role = role
        return user
    }

    fun convertToUserByInstance(user: User): User {
        user.age = age
        user.birthday = birthday
        user.marriage = marriage
        user.name = name
        user.password = password
        user.userName = userName
        return user
    }
}
