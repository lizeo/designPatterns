package ey.kotlin.spring.boot.learn.automotive

import java.math.BigDecimal
import java.math.BigInteger
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
open class Component(name : String, price : BigDecimal, type : PartType) {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    lateinit var id : BigInteger
}