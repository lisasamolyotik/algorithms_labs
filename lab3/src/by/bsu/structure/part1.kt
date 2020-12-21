package by.bsu.structure

import kotlin.random.Random
import kotlin.system.measureTimeMillis

/*Составить программу, которая формирует одномерный массив
из n случайных чисел. Получить из него два новых массива: один из
четных чисел, а другой из нечетных. Значение n меняется в пределах
от 10 до 50 миллионов.*/

fun main() {
    val min = 10
    val max = 500
    val n = 20
    val time = measureTimeMillis {
        val array = createArray(n, min, max)
            println("Размерность массива: $n")
            println("Сгенерированный массив: $array")
            println("Нечетная часть: ${getOddPart(array)}")
            println("Четная часть: ${getEvenPart(array)}")
    }
    println("$n - $time")

}

fun createArray(n: Int, min: Int, max: Int): ArrayList<Int> {
    val array: ArrayList<Int> = ArrayList()
    for (i in 0..n) {
        array.add(Random.nextInt(min, max))
    }
    return array
}

fun getOddPart(array: ArrayList<Int>): ArrayList<Int> {
    val result = ArrayList<Int>()
    for (item in array) {
        if (item % 2 != 0) {
            result.add(item)
        }
    }
    return result
}

fun getEvenPart(array: ArrayList<Int>): ArrayList<Int> {
    val result = ArrayList<Int>()
    for (item in array) {
        if (item % 2 == 0) {
            result.add(item)
        }
    }
    return result
}