package ey.kotlin.spring.boot.learn.books

import java.math.BigDecimal
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class Book(@Id val name : String = "",
                val publisher : String = "",
                val pages : Int = 0,
                val originalPrice : BigDecimal = BigDecimal.ZERO,
                val type : BookType = BookType.CLASSIC) {

}

enum class BookType (val id : Int) {
    COMEDY(0),
    CLASSIC(1),
    HISTORY(2),
    CHILD(3),
    DRAMA(4)
}