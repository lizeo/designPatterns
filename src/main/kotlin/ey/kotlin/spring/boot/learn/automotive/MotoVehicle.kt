package ey.kotlin.spring.boot.learn.automotive

import org.hibernate.annotations.Cascade
import org.hibernate.annotations.CascadeType
import java.math.BigInteger
import javax.persistence.Entity
import javax.persistence.JoinColumn
import javax.persistence.OneToMany

@Entity
open class MotoVehicle(name: String = "moto vehicle",
                       id: BigInteger = BigInteger.ZERO,
                       vin: String = "VIN0",
                       @Cascade(CascadeType.ALL) @OneToMany @JoinColumn(name="ID") var components : MutableList<Component> = ArrayList(16))
    : Vehicle(name, id) {

    open fun addComponent(component: Component) {
        components.add(component)
    }

}