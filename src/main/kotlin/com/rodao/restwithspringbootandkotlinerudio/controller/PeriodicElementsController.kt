package com.rodao.restwithspringbootandkotlinerudio.controller

import com.rodao.restwithspringbootandkotlinerudio.entity.PeriodicElements
import com.rodao.restwithspringbootandkotlinerudio.services.PeriodicElementsService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/periodic-elements")
class PeriodicElementsController {

    @Autowired
    lateinit var service: PeriodicElementsService

    @GetMapping
    fun getAll(): List<PeriodicElements> {
        return service.getAll()
    }

    @GetMapping(value = ["/{id}"])
    fun getById(@PathVariable("id") id: Long): PeriodicElements {
        return service.getById(id)
    }

    @PutMapping(value = ["/{id}"])
    fun updateById(@PathVariable("id") id: Long, @RequestBody periodicElements: PeriodicElements): PeriodicElements {
        return service.update(id, periodicElements)
    }

    @PostMapping()
    fun create(@RequestBody periodicElements: PeriodicElements): PeriodicElements {
        return service.save(periodicElements)
    }
}