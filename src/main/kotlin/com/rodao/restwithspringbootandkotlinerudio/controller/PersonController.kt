package com.rodao.restwithspringbootandkotlinerudio.controller

import com.rodao.restwithspringbootandkotlinerudio.model.Person
import com.rodao.restwithspringbootandkotlinerudio.services.PersonService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/person")
class PersonController {

    @Autowired
    lateinit var service: PersonService

    @RequestMapping(
        method = [RequestMethod.GET],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun findAll(): List<Person> {
        return service.findAll()
    }

    @RequestMapping(
        value = ["/{id}"], method = [RequestMethod.GET],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun getById(@PathVariable(value = "id") id: Long): Person {
        return service.findById(id)
    }

    @RequestMapping(
        method = [RequestMethod.POST],
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun create(@RequestBody person: Person): Person {
        return service.create(person)
    }

    @RequestMapping(
        value = ["/{id}"], method = [RequestMethod.PUT],
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun update(@RequestBody person: Person): Person {
        return service.update(person)
    }

    @RequestMapping(
        value = ["/{id}"], method = [RequestMethod.DELETE]
    )
    fun deleteById(@PathVariable(value = "id") id: Long) {
        return service.delete(id)
    }


}