package com.rodao.restwithspringbootandkotlinerudio.services

import com.rodao.restwithspringbootandkotlinerudio.exceptions.ResourceNotFoundException
import com.rodao.restwithspringbootandkotlinerudio.model.Person
import com.rodao.restwithspringbootandkotlinerudio.repository.PersonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.concurrent.atomic.AtomicLong
import java.util.logging.Logger

@Service
class PersonService {

    @Autowired
    private lateinit var repository: PersonRepository

    private val counter: AtomicLong = AtomicLong()
    private val logger = Logger.getLogger(PersonService::class.java.name)

    fun findAll(): List<Person> {
        logger.info("Finding all people")
        return repository.findAll()
    }

    fun findById(id: Long): Person {
        logger.info("Finding one person")
        return repository.findById(id).orElseThrow {
            ResourceNotFoundException("No records found for this ID!")
        }
    }

    fun create(person: Person): Person {
        logger.info("Creating new person")
        return repository.save(person)
    }

    fun update(person: Person) {
        logger.info("Updating one person with ID: $person.id")

        val entity = repository.findById(person.id).orElseThrow {
            ResourceNotFoundException("No records found for this ID!")}

         entity.firstName = person.firstName
        entity.lastName = person.lastName
        entity.address = person.address
        entity.gender = person.gender


        }

        fun delete(id: Long) {
            logger.info("Deleting one person with ID: $id")
            repository.deleteById(id)
        }

    }