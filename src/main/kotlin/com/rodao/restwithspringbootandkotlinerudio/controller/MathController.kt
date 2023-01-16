package com.rodao.restwithspringbootandkotlinerudio.controller

import com.rodao.restwithspringbootandkotlinerudio.exceptions.UnsupportedMathOperationException
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MathController {

    @RequestMapping("/math/sum/{numberOne}/{numberTwo}")
    fun sum(
        @PathVariable(value = "numberOne") numberOne: String,
        @PathVariable(value = "numberTwo") numberTwo: String
    ): Double {

        if (!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw UnsupportedMathOperationException("Os parâmetros devem ser numéricos, gentileza verificar")

        return convertToDouble(numberOne) + convertToDouble(numberTwo)
    }


    private fun isNumeric(number: String): Boolean {
        if (number.isBlank()) return false

        val newNumber = number.replace(",".toRegex(), ".")
        return newNumber.matches("""[-+?]?[0-9]*\.?[0-9]+""".toRegex())

    }

    private fun convertToDouble(number: String): Double {
        if (number.isBlank()) return 0.0

        val newNumber = number.replace(",".toRegex(), ".")
        return if (isNumeric(newNumber)) number.toDouble() else 0.0
    }

}