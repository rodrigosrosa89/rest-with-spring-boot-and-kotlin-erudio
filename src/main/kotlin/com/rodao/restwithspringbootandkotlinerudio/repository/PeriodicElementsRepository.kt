package com.rodao.restwithspringbootandkotlinerudio.repository

import com.rodao.restwithspringbootandkotlinerudio.entity.PeriodicElements
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PeriodicElementsRepository : JpaRepository<PeriodicElements, Long> {
}