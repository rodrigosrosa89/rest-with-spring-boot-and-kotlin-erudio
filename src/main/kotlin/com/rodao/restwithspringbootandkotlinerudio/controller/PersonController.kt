package com.rodao.restwithspringbootandkotlinerudio.controller

import com.rodao.restwithspringbootandkotlinerudio.model.vo.v1.PersonVO
import com.rodao.restwithspringbootandkotlinerudio.model.vo.v2.PersonVO as PersonVOv2
import com.rodao.restwithspringbootandkotlinerudio.services.PersonService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/person")
class PersonController {

    @Autowired
    lateinit var service: PersonService

    @GetMapping(
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun findAll(): List<PersonVO> {
        return service.findAll()
    }

    @GetMapping(
        value = ["/{id}"],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun getById(@PathVariable(value = "id") id: Long): PersonVO {
        return service.findById(id)
    }

    @PostMapping(
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun create(@RequestBody person: PersonVO): PersonVO {
        return service.create(person)
    }

    @PostMapping(value = ["/v2"],
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun createV2(@RequestBody person: PersonVOv2): PersonVOv2 {
        return service.createV2(person)
    }

    @PutMapping(
        value = ["/{id}"],
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun update(@PathVariable(value = "id") id: Long, @RequestBody person: PersonVO): PersonVO {
        return service.update(id, person)
    }

    @DeleteMapping(
        value = ["/{id}"]
    )
    fun deleteById(@PathVariable(value = "id") id: Long): ResponseEntity<*> {
        service.delete(id)
        return ResponseEntity.noContent().build<Any>()
    }


}