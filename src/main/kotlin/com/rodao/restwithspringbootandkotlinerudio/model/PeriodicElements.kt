package com.rodao.restwithspringbootandkotlinerudio.model

import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(name = "periodic-elements")
class PeriodicElements {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0;

    var name: String = "";

    lateinit var position: BigDecimal

    lateinit var weight: BigDecimal

    var symbol: String = "";
}