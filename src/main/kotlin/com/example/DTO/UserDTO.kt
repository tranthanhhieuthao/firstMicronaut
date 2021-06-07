package com.example.DTO

import com.example.model.User
import com.nimbusds.jose.crypto.PasswordBasedEncrypter
import com.nimbusds.jose.crypto.impl.PasswordBasedCryptoProvider
import java.util.Date

data class UserDTO(
    var name: String = "",
    var userName: String = "",
    var birthday: Date = Date(),
    var age: Int = 0,
    var marriage: Boolean = false,
    var password: String = "123456",
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
