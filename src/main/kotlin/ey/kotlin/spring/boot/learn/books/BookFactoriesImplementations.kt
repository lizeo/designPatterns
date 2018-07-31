package ey.kotlin.spring.boot.learn.books

import java.math.BigDecimal

class FamilyBookFactory : AbstractBookFactory() {

    override fun produce(i: Int): Book {
        return Book("", "", i, BigDecimal.valueOf(32.95), BookType.COMEDY)
    }

}

class SeriousBookFactory : AbstractBookFactory() {
    override fun produce(i: Int): Book {
        return Book("", "", i, BigDecimal.valueOf(19.95), BookType.DRAMA)
    }

}