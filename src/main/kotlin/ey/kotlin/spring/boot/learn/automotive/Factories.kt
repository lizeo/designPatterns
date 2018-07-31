package ey.kotlin.spring.boot.learn.automotive

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service
import java.math.BigDecimal

open abstract class VehicleFactory(@Autowired var componentFactory : ComponentFactory) {

    abstract fun createVehicle(type:String) : Vehicle

}

@Service("FerrariCarFactory") class FerrariCarFactory(@Qualifier(value ="FerrariComponentFactory") @Autowired componentFactory: ComponentFactory) : VehicleFactory(componentFactory) {

    override fun createVehicle(type: String) : Vehicle {
        val createComponent = componentFactory.createComponent("engine")
        val car : Car = Car("")
        car.addComponent(createComponent)
        return car
    }
}

open abstract class ComponentFactory {
    abstract fun createComponent(componentType:String) : Component
}

@Service("FerrariComponentFactory") class FerrariComponentFactory : ComponentFactory() {
    override fun createComponent(componentType: String): Component {
        return when (componentType) {
            "engine" -> Component("Silnik Ferrari - bestia", BigDecimal.TEN, PartType.ENGINE)
            "breaks" -> Component("Hamulce Ferrari - chujowe bo po co w ogóle hamować", BigDecimal.TEN, PartType.BREAKS)
            else -> Component("złom", BigDecimal.ONE, PartType.TURBO)
        }
    }
}

@Service("FordComponentFactory") class FordComponentFactory : ComponentFactory() {
    override fun createComponent(componentType: String): Component {
        return when (componentType) {
            "engine" -> Component("Silnik forda", BigDecimal.TEN, PartType.ENGINE)
            "breaks" -> Component("Hamulce forda", BigDecimal.TEN, PartType.BREAKS)
            else -> Component("złom", BigDecimal.ONE, PartType.TURBO)
        }
    }

}