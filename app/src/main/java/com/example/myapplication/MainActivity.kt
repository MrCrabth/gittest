package ru.gazprombank.logic_unit.sumCalc.calculator

import kotlin.math.*

object SumCalculationPostfixSolver {

    val PLUS = "+"
    val MINUS = "-"
    val MULTIPLICATION = "*"
    val POW = "^"
    val ROUND = "round"
    val DIVIDE = "/"
    val MINIMUM_COLLECTION_SIZE = 2
    val ROUND_CONST = 10.0
    val IS_NULL = 0.0
    val testGit = "test"

    private fun parseLine(line: String, map: Map<String, String>): List<String> {
        val listWithSubstitutions: MutableList<String> = mutableListOf()
        val signList = arrayListOf<String>(
                PLUS,
                MINUS,
                MULTIPLICATION,
                POW,
                ROUND,
                DIVIDE
        )

        val splitLineList: List<String> = line
                .replace(Regex("""[{}]"""), "")
                .split(" ")

        splitLineList.forEach { listValue ->
            if (map.containsKey(listValue)) {
                listWithSubstitutions.add(map.get(listValue)!!)
            } else {
                listWithSubstitutions.add(listValue)
            }
        }

        listWithSubstitutions.forEach { listValue ->
            if (!Regex("[\\d]").containsMatchIn(listValue) && !signList.contains(listValue)) {
                throw Exception("В строке присутствует неопознанный символ $listValue")
            }
        }

        return listWithSubstitutions
    }

    //Функция для округление дробной части числа someRound до указанного количества знаков после запятой, указанного в параметр power
    private fun round(someRound: Double, power: Int): Double {
        val variable1: Double = ROUND_CONST.pow(power.toDouble())
        val variable2 = someRound * variable1
        val variable3 = kotlin.math.round(variable2)

        return variable3 / variable1
    }

    private fun Double.isInteger(): Boolean {
        return (this % 1 == IS_NULL)
    }

    private fun calcPostFix(line: String, map: Map<String, String>): Double {
        val parseLineList = parseLine(line, map)
        val stack = mutableListOf<Double>()

        parseLineList.forEach { item ->
            if (Regex("[\\d]").containsMatchIn(item)) {
                stack.add(item.toDouble())

                return@forEach
            }

            if (stack.size < MINIMUM_COLLECTION_SIZE) {
                throw Exception("Передана некорректная строка")
            }

            val last = stack.last()
            val preLast = stack[stack.lastIndex - 1]

            val result = when (item) {
                PLUS -> {
                    last + preLast
                }

                MULTIPLICATION -> {
                    last * preLast
                }

                DIVIDE -> {
                    preLast / last
                }

                MINUS -> {
                    preLast - last
                }

                POW -> {
                    preLast.pow(last)
                }

                ROUND -> {
                    if (!last.isInteger()) {
                        throw Exception("степень указана в некорректном формате : $last")
                    }
                    round(preLast, last.toInt())
                }

                else -> {
                    throw Exception("Неизвестная операция : $item")
                }
            }

            stack[stack.lastIndex - 1] = result
            stack.removeAt(stack.lastIndex)
        }

        return stack.first()
    }

    fun postfixExpression(line: String, map: Map<String, String>): String {
        return calcPostFix(line, map).toString()
    }

    fun testGitFun(){
        println(testGit)
    }
    fun test2(){
        println(ROUND)
    }
    fun InMain(){
        println("in main")
    }
    fun anotherfun(){
        println("asd")
    }
    fun smth(){

    }
}



fun main() {
    var mapRes = mapOf<String, String>("name" to "4", "age" to "4.7879")
    println(SumCalculationPostfixSolver.postfixExpression("name 2 -", mapRes))
}
