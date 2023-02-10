package com.rodao.restwithspringbootandkotlinerudio.repository

import com.rodao.restwithspringbootandkotlinerudio.model.Person
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PersonRepository : JpaRepository<Person, Long?> {
}