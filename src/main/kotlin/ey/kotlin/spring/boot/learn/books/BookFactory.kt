package ey.kotlin.spring.boot.learn.books

abstract class AbstractBookFactory {

    abstract fun produce (i : Int) : Book
}