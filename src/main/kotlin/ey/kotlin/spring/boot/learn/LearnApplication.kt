package ey.kotlin.spring.boot.learn

import ey.kotlin.spring.boot.learn.automotive.*
import ey.kotlin.spring.boot.learn.books.AbstractBookFactory
import ey.kotlin.spring.boot.learn.books.FamilyBookFactory
import org.springframework.beans.factory.getBean
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.ConfigurableApplicationContext
import javax.transaction.Transactional
import javax.transaction.Transactional.TxType.REQUIRES_NEW

@SpringBootApplication
class LearnApplication {

    @Transactional fun doSthInTransaction(applicationContext: ConfigurableApplicationContext) {
        val bean = applicationContext.getBean<VehicleRepository>(VehicleRepository::class)
        bean.saveAndFlush(Motorcycle(""))
        bean.saveAndFlush(Car(""))
    }

}

fun main(args: Array<String>) {
    val applicationContext = runApplication<LearnApplication>(*args)
    val bean = applicationContext.getBean<FerrariCarFactory>(FerrariCarFactory::class)
    val createVehicle = bean.createVehicle("Ferrari")
    val vehicleRepo = applicationContext.getBean<VehicleRepository>(VehicleRepository::class)
    for (i in 1..5) {
        saveVehicle(vehicleRepo, bean.createVehicle("Ferrari"))
    }
}

@Transactional(REQUIRES_NEW) private fun saveVehicle(vehicleRepo: VehicleRepository, createVehicle: Vehicle) {
    vehicleRepo.saveAndFlush(createVehicle)
}

