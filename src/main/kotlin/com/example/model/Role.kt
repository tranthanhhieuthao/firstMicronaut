package com.example.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Role(
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      var id: Long = -1,
      var type: String = "USER"
){}
