package com.rodao.restwithspringbootandkotlinerudio.services

import com.rodao.restwithspringbootandkotlinerudio.model.Person
import org.springframework.stereotype.Service
import java.util.concurrent.atomic.AtomicLong
import java.util.logging.Logger

@Service
class PersonService {

    private val counter: AtomicLong = AtomicLong()
    private val logger = Logger.getLogger(PersonService::class.java.name)

    fun findAll(): List<Person> {
        logger.info("Finding all people")

        val persons: MutableList<Person> = ArrayList()
        for (i in 0..7) {
            val person = mockPerson(counter.toInt())
            persons.add(person)
        }

        return persons
    }

    fun findById(id: Long): Person {
        logger.info("Finding one person")

        return Person(
            id = counter.incrementAndGet(),
            "Rodrigo",
            "Rosa",
            "Belo Horizonte MG",
            "male"
        )

    }

    fun create(person: Person): Person {
        return person
    }

    fun update(person: Person) = person

    fun delete(id: Long) {}

    private fun mockPerson(i: Int): Person {
        return Person(
            id = counter.incrementAndGet(),
            "Person name $i",
            "Last name $i",
            "Belo Horizonte MG",
            "male"
        )

    }


}