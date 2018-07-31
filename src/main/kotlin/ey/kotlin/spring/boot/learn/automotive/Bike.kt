package ey.kotlin.spring.boot.learn.automotive

import javax.persistence.Entity

@Entity
class Bike(bikeType : String = "Cross") : Vehicle() {

}