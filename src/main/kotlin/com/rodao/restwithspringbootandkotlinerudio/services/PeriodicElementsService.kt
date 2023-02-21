package com.rodao.restwithspringbootandkotlinerudio.services

import com.rodao.restwithspringbootandkotlinerudio.entity.PeriodicElements
import com.rodao.restwithspringbootandkotlinerudio.repository.PeriodicElementsRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PeriodicElementsService {

    @Autowired
    lateinit var repository: PeriodicElementsRepository

    fun getAll(): List<PeriodicElements> {
        return repository.findAll()
    }

    fun getById(id: Long): PeriodicElements {
        return repository.findById(id).get()
    }

    fun save(periodicElements: PeriodicElements): PeriodicElements {
        return repository.save(periodicElements)
    }

    fun update(id: Long, periodicElements: PeriodicElements): PeriodicElements {
        val periodicElementsEntity = repository.findById(id).get()
        periodicElementsEntity.name = periodicElements.name
        periodicElementsEntity.position = periodicElements.position
        periodicElementsEntity.weight = periodicElements.weight
        periodicElementsEntity.symbol = periodicElements.symbol

        return save(periodicElementsEntity)
    }
}