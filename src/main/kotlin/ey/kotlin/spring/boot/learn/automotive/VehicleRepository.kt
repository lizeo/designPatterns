package ey.kotlin.spring.boot.learn.automotive

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.math.BigInteger

@Repository interface VehicleRepository : JpaRepository<Vehicle, BigInteger> {
}

