package by.bsu.structure

import kotlin.system.measureNanoTime
import kotlin.system.measureTimeMillis

/*Разработать алгоритм и программу интерполирующего поиска.
В качестве исходных данных использовать массив целых чисел,
который вводится с клавиатуры. Аргумент поиска – число*/

fun main() {
    val min = 10
    val max = 50
    val n = 10
    val time = measureNanoTime {

        val array = createArray(n, min, max)
        array.sort()
        println("Размерность массива: $n")
        println("Сгенерированный массив: $array")
        println("Введите число, которое будем искать ")
        val toFind = readLine()?.toInt()!!
        println("Найти число: $toFind")
        val result = interpolationSearch(array, toFind)

        if (result != -1) {
            println("Первый индекс искомого числа: $result")
        } else {
            println("Число $toFind не найдено")
        }
    }
    println(time)
}

// Возвращает индекс элемента со значением toFind или -1, если такого элемента не существует
fun interpolationSearch(sortedArray: ArrayList<Int>, toFind: Int): Int {
    var mid: Int
    var low = 0
    var high = sortedArray.size - 1
    while (sortedArray[low] < toFind && sortedArray[high] > toFind) {
        if (sortedArray[high] == sortedArray[low])
            break
        mid = low + (toFind - sortedArray[low]) * (high - low) / (sortedArray[high] - sortedArray[low])
        if (sortedArray[mid] < toFind)
            low = mid + 1
        else if (sortedArray[mid] > toFind)
            high = mid - 1
        else
            return mid
    }
    if (sortedArray[low] == toFind) return low
    return if (sortedArray[high] == toFind) high else -1
}