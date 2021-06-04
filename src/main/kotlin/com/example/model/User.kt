package com.example.model

import javax.persistence.*

@Entity
@Table(name = "users")
class User (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long = -1, var name: String = "") {
}