package by.bsu.structure

import kotlin.system.measureNanoTime

/*Разработать следующие алгоритмы и программы с
использованием рекурсии:
линейного поиска целочисленного значения ключа в заданном
массиве и вывода этого массива. */

fun main() {
    val min = 10
    val max = 50
    val n = 20
    val time = measureNanoTime {

        val array = createArray(n, min, max)
            println("Размерность массива: $n")
            println("Сгенерированный массив: ")
            printArray(array)
            println("Введите число, которое будем искать ")
            val toFind = readLine()?.toInt()!!
            println("Найти число: $toFind")
        val result = linearSearch(array, toFind)

        if (result != -1) {
            println("Первый индекс искомого числа: $result")
        } else {
            println("Число $toFind не найдено")
        }
    }
    println(time)
}

fun linearSearch(array: ArrayList<Int>, key: Int, i: Int = 0): Int {
    return if (i < array.size && array[i] == key) {
        i
    } else if (i < array.size && array[0] != key) {
        linearSearch(array, key, i + 1)
    } else {
        -1
    }
}

fun printArray(array: ArrayList<Int>, i: Int = 0) {
    when (i) {
        0 -> {
            print("[${array[i]}, ")
            printArray(array, i + 1)
        }
        in 1 until array.size - 1 -> {
            print("${array[i]}, ")
            printArray(array, i + 1)
        }
        array.size - 1 -> print("${array[i]}]\n")
    }
}

