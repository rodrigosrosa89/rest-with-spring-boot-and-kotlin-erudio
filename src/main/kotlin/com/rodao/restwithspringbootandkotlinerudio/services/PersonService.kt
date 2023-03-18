package com.rodao.restwithspringbootandkotlinerudio.services

import com.rodao.restwithspringbootandkotlinerudio.entity.Person
import com.rodao.restwithspringbootandkotlinerudio.exceptions.ResourceNotFoundException
import com.rodao.restwithspringbootandkotlinerudio.mapper.DozerMapper
import com.rodao.restwithspringbootandkotlinerudio.mapper.ModelProjectMapper
import com.rodao.restwithspringbootandkotlinerudio.mapper.custom.PersonMapper
import com.rodao.restwithspringbootandkotlinerudio.model.vo.v1.PersonVO
import com.rodao.restwithspringbootandkotlinerudio.repository.PersonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.concurrent.atomic.AtomicLong
import java.util.logging.Logger
import com.rodao.restwithspringbootandkotlinerudio.model.vo.v2.PersonVO as PersonVOV2

@Service
class PersonService {

    @Autowired
    private lateinit var repository: PersonRepository

    @Autowired
    private lateinit var mapper: PersonMapper

    private val counter: AtomicLong = AtomicLong()
    private val logger = Logger.getLogger(PersonService::class.java.name)

    fun findAll(): List<PersonVO> {
        logger.info("Finding all people")
        val personEntityList = repository.findAll()
        return DozerMapper.parseListObjects(personEntityList, PersonVO::class.java)
    }

    fun findById(id: Long): PersonVO {
        logger.info("Finding one person")
        val personEntity = repository.findById(id).orElseThrow {
            ResourceNotFoundException("No records found for this ID!")
        }
        return ModelProjectMapper.parseObject(personEntity, PersonVO::class.java)
    }

    fun create(personVO: PersonVO): PersonVO {
        logger.info("Creating new person")
        val personEntity: Person = DozerMapper.parseObject(personVO, Person::class.java)
        return DozerMapper.parseObject(repository.save(personEntity), PersonVO::class.java)
    }

    fun update(id: Long, personVO: PersonVO): PersonVO {
        logger.info("Updating one person with ID: $id")

        val entity = repository.findById(id).orElseThrow {
            ResourceNotFoundException("No records found for this ID!")
        }

        entity.firstName = personVO.firstName
        entity.lastName = personVO.lastName
        entity.address = personVO.address
        entity.gender = personVO.gender
        return ModelProjectMapper.parseObject(repository.save(entity), PersonVO::class.java)


    }

    fun delete(id: Long) {
        logger.info("Deleting one person with ID: $id")
        repository.deleteById(id)
    }

    fun createV2(person: PersonVOV2): PersonVOV2 {
        logger.info("Creating new person")
        val personEntity: Person = mapper.mapVOToEntity(person)
        return mapper.mapEntityToVO(repository.save(personEntity))
    }

}