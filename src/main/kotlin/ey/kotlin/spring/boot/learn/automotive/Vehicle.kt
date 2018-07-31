package ey.kotlin.spring.boot.learn.automotive

import java.math.BigInteger
import javax.persistence.*

@Entity @Inheritance(strategy=InheritanceType.SINGLE_TABLE)
open class Vehicle (
        open val name : String = "abstractVehicle",
        @Id @GeneratedValue var id : BigInteger){

    constructor() : this("", BigInteger.ZERO)
}

enum class PartType {
    ENGINE,
    BREAKS,
    WHEELS,
    TURBO,
    RIMS,
    STEER,
    COMPUTER
}