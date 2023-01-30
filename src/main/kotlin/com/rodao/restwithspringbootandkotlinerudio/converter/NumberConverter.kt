package com.rodao.restwithspringbootandkotlinerudio.converter

class NumberConverter {

    fun isNumeric(number: String): Boolean {
        if (number.isBlank()) return false

        val newNumber = number.replace(",".toRegex(), ".")
        return newNumber.matches("""[-+?]?[0-9]*\.?[0-9]+""".toRegex())

    }

    fun convertToDouble(number: String): Double {
        if (number.isBlank()) return 0.0

        val newNumber = number.replace(",".toRegex(), ".")
        return if (isNumeric(newNumber)) number.toDouble() else 0.0
    }


}