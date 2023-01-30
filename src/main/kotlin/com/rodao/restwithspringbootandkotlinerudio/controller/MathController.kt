package com.rodao.restwithspringbootandkotlinerudio.controller

import com.rodao.restwithspringbootandkotlinerudio.converter.NumberConverter
import com.rodao.restwithspringbootandkotlinerudio.exceptions.UnsupportedMathOperationException
import com.rodao.restwithspringbootandkotlinerudio.math.SimpleMath
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MathController {

    lateinit var numberConverter: NumberConverter

    private val math: SimpleMath = SimpleMath()

    @RequestMapping("/math/sum/{numberOne}/{numberTwo}")
    fun sum(
        @PathVariable(value = "numberOne") numberOne: String,
        @PathVariable(value = "numberTwo") numberTwo: String
    ): Double {

        if (!numberConverter.isNumeric(numberOne) || !numberConverter.isNumeric(numberTwo))
            throw UnsupportedMathOperationException("Os parâmetros devem ser numéricos, gentileza verificar")

        return math.sum(numberConverter.convertToDouble(numberOne), numberConverter.convertToDouble(numberTwo))
    }

    @RequestMapping("/math/subtraction/{numberOne}/{numberTwo}")
    fun subtraction(
        @PathVariable(value = "numberOne") numberOne: String,
        @PathVariable(value = "numberTwo") numberTwo: String
    ): Double {

        if (!numberConverter.isNumeric(numberOne) || !numberConverter.isNumeric(numberTwo))
            throw UnsupportedMathOperationException("Os parâmetros devem ser numéricos, gentileza verificar")

        return math.subtraction(numberConverter.convertToDouble(numberOne), numberConverter.convertToDouble(numberTwo))
    }

    @RequestMapping("/math/multiply/{numberOne}/{numberTwo}")
    fun multiply(
        @PathVariable(value = "numberOne") numberOne: String,
        @PathVariable(value = "numberTwo") numberTwo: String
    ): Double {

        if (!numberConverter.isNumeric(numberOne) || !numberConverter.isNumeric(numberTwo))
            throw UnsupportedMathOperationException("Os parâmetros devem ser numéricos, gentileza verificar")

        return math.multiply(numberConverter.convertToDouble(numberOne), numberConverter.convertToDouble(numberTwo))
    }

    @RequestMapping("/math/division/{numberOne}/{numberTwo}")
    fun division(
        @PathVariable(value = "numberOne") numberOne: String,
        @PathVariable(value = "numberTwo") numberTwo: String
    ): Double {

        if (!numberConverter.isNumeric(numberOne) || !numberConverter.isNumeric(numberTwo))
            throw UnsupportedMathOperationException("Os parâmetros devem ser numéricos, gentileza verificar")

        return math.division(numberConverter.convertToDouble(numberOne), numberConverter.convertToDouble(numberTwo))
    }

    @RequestMapping("/mean/division/{numberOne}/{numberTwo}")
    fun mean(
        @PathVariable(value = "numberOne") numberOne: String,
        @PathVariable(value = "numberTwo") numberTwo: String
    ): Double {

        if (!numberConverter.isNumeric(numberOne) || !numberConverter.isNumeric(numberTwo))
            throw UnsupportedMathOperationException("Os parâmetros devem ser numéricos, gentileza verificar")

        return math.mean(numberConverter.convertToDouble(numberOne), numberConverter.convertToDouble(numberTwo))
    }


}