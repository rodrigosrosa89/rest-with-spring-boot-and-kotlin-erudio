package com.rodao.restwithspringbootandkotlinerudio.mapper.custom

import com.rodao.restwithspringbootandkotlinerudio.entity.Person
import com.rodao.restwithspringbootandkotlinerudio.model.vo.v2.PersonVO
import org.springframework.stereotype.Service
import java.util.*

@Service
class PersonMapper {

    fun mapEntityToVO(person: Person): PersonVO {
        val vo = PersonVO()
        vo.firstName = person.firstName
        vo.lastName = person.lastName
        vo.id = person.id
        vo.address = person.address
        vo.gender = person.gender
        vo.birthday = Date()
        return vo
    }

    fun mapVOToEntity(vo: PersonVO): Person {
        val personEntity = Person()
        personEntity.firstName = vo.firstName
        personEntity.lastName = vo.lastName
        personEntity.id = vo.id
        personEntity.address = vo.address
        personEntity.gender = vo.gender
//        person.birthday = vo.birthday
        return personEntity
    }

}