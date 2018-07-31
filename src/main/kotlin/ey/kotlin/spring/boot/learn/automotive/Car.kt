package ey.kotlin.spring.boot.learn.automotive

import javax.persistence.Entity

@Entity
class Car(val sth : String) : MotoVehicle() {

    fun addComponent(component: Component, string : String) {

    }
}