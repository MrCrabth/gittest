package com.example.myapplication

import ru.gazprombank.logic_unit.sumCalc.calculator.SumCalculationPostfixSolver
import java.lang.Exception
import kotlin.test.*
import kotlin.math.*

//fun main() {
//    var list = mutableMapOf<String,String>("totalCreditQty" to "10", "rate" to "15", "term" to "20")
////
//    val str = "{{totalCreditQty}} {{rate}} * 100 / 12 / 1 1 {{rate}} 100 / 12 / + 1 {{term}} - ^ - / 0 round"
////
////    val str1 = "{{rate}} {{totalCreditQty}} - {{term}} +"
////
////    val str2 = "1 2 +"
////
////    @Test
////
////    assert()
////    assertTrue
//    println(SumCalculationPostfixSolver.postfixExpression(str, list))
//
//
//
////    var ls = 2.4654
//
//
////    val decimal = BigDecimal(3.14149265359).setScale(3, RoundingMode.HALF_EVEN)
////    println(decimal)
//}

class SumCalcTest {

    @Test
    fun AssertionsSuccessTest() {
        var list = mutableMapOf<String, String>("totalCreditQty" to "10", "rate" to "15", "term" to "20")
        val variable1 = "{{totalCreditQty}} {{rate}} * 100 / 12 / 1 1 {{rate}} 100 / 12 / + 1 {{term}} - ^ - / 0 round"
        val variable2 = "1 2 +"
        val variable3 = "1 2 * 3 + 2 ^"
        val variable4 = "4.4567 2.0 round"

        assertTrue(SumCalculationPostfixSolver.postfixExpression(variable1, list) == "1.0")
        assertTrue(SumCalculationPostfixSolver.postfixExpression(variable2, list) == "3.0")
        assertTrue(SumCalculationPostfixSolver.postfixExpression(variable3, list) == "25.0")
        assertTrue(SumCalculationPostfixSolver.postfixExpression(variable4, list) == "4.46")
    }

    @Test
    fun assertionsFailedTest() {
        var list = mutableMapOf<String, String>("totalCreditQty" to "10", "rate" to "15", "term" to "20")
        val variable1 = "{{totalCreditQty}} {{rate}} * 100 / 12 / 1 1 {{rate}} 100 / 12 / + 1 {{term}} - ^ - / 0 round"
        val variable2 = "1 2 -"
        val variable3 = "1 2 / 3 +"
        val variable4 = "4.4567 2 round"

        assertFalse(SumCalculationPostfixSolver.postfixExpression(variable1, list) == "2.0")
        assertFalse(SumCalculationPostfixSolver.postfixExpression(variable2, list) == "1.0")
        assertFalse(SumCalculationPostfixSolver.postfixExpression(variable3, list) == "3.6")
        assertFalse(SumCalculationPostfixSolver.postfixExpression(variable4, list) == "4.45")
    }
}
//
//fun main() {
//    val variable1 = "{{totalCreditQty}} {{rate}} * 100 / 12 / 1 1 {{rate}} 100 / 12 / + 1 {{term}} - ^ - / 0 round"
//    val variable2 = "2.5565345 1 round"
//    var list = mutableMapOf<String, String>("totalCreditQty" to "10", "rate" to "15", "term" to "20")
//    println(SumCalculationPostfixSolver.postfixExpression(variable2,list))
//}


//fun okr(b : Double){
//    var res = String.format("%.1f", b).toDouble()
//}
//
//fun main() {
//
//
//    println(round(2.644, 2.0))
//    val qwe : Double = 2.1
//    val qwer = qwe
//
//    println(qwe == qwer.toInt().toDouble())


//    println(10.0.pow(2.0))
////    println(round(2.6666))
//    println(okr(12.42))
//    var list = mutableMapOf<String,String>("totalCreditQty" to "10", "rate" to "15", "term" to "20")
//        val str = "{{totalCreditQty}} {{rate}} * 100 / 12 / 1 1 {{rate}} 100 / 12 / + 1 {{term}} - ^ - / 0 round"
//    val str1 = "1 2 -"
//    println(SumCalculationPostfixSolver.postfixExpression(str1, list))
//    println("-1.0" == SumCalculationPostfixSolver.postfixExpression(str1, list))


//    fun round(value: Double, places : Double) : Double{
//        if (places < 0) throw Exception("Меньше 0")
//
//        var factor : Double = places.pow(10)
//        var value1 = value * factor.toInt()
//        var tmp: Double = round(value1)
//        return  tmp.toInt() / factor;

//    var a1 = 123123
//    println(a1.size)
//    }

//}
//
//
//fun round (a : Double, b: Double) : Double{
//    var c : Double = 10.0.pow(b)
//    println(c)
//    var d = a * c
//    println(d)
//    var tmp = round(d)
//    println(tmp)
//    return tmp/c
//}

//
////sdf

//private fun Double.isInteger() : Boolean{
//    return this % 1 == 0.0
//}
//fun main() {
//    val ad = 2
//    var asd = ad.toDouble()%1
//    println(asd == 0.0)
//}














//class SumCalcTest {
//    @Test
//    fun `success postfix solver test`() {
//        var list = mutableMapOf<String, String>("totalCreditQty" to "10", "rate" to "15", "term" to "20")
//        val str = "{{totalCreditQty}} {{rate}} * 100 / 12 / 1 1 {{rate}} 100 / 12 / + 1 {{term}} - ^ - / 0 round"
//        val str1 = "1 2 +"
//        val str2 = "1 2 * 3 + 2 ^"
//
//        assertTrue(SumCalculationPostfixSolver.postfixExpression(str, list) == "1.0")
//        assertTrue(SumCalculationPostfixSolver.postfixExpression(str1, list) == "3.0")
//        assertTrue(SumCalculationPostfixSolver.postfixExpression(str2, list) == "25.0")
//    }
//
//    @Test
//    fun `error postfix solver test`() {
//        var list = mutableMapOf<String, String>("totalCreditQty" to "10", "rate" to "15", "term" to "20")
//        val str = "{{totalCreditQty}} {{rate}} * 100 / 12 / 1 1 {{rate}} 100 / 12 / + 1 {{term}} - ^ - / 0 round"
//        val str1 = "1 2 -"
//        val str2 = "1 2 / 3 + "
//
//        assertFalse(SumCalculationPostfixSolver.postfixExpression(str, list) == "2.0")
//        assertFalse(SumCalculationPostfixSolver.postfixExpression(str, list) == "1.0")
//        assertFalse(SumCalculationPostfixSolver.postfixExpression(str, list) == "1.5")
//    }
//}