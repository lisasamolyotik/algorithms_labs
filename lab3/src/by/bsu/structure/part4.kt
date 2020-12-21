package by.bsu.structure

import kotlin.system.measureTimeMillis

/*Составить две программы, которые реализуют алгоритмы
ускоренной сортировки «пузырьком» и сортировки Шелла. Исходные
данные задавать с помощью датчика случайных чисел.
*/

fun main() {
    val min = 0
    val max = 500
    val n = 20000
    val array = createArray(n, min, max)
    val time = measureTimeMillis {
        println("Размерность массива: $n")
        println("Сгенерированный массив: $array")
        println("Сортированный пузырьком массив: ${bubbleSort(array)}")
        println("Сортированный шеллом массив: ${shellSort(array)}")
    }
    println("$n -- $time")
}

fun bubbleSort(array: ArrayList<Int>): ArrayList<Int> {
    var isSorted = false
    var buf: Int
    while (!isSorted) {
        isSorted = true
        for (i in 0 until array.size - 1) {
            if (array[i] > array[i + 1]) {
                isSorted = false
                buf = array[i]
                array[i] = array[i + 1]
                array[i + 1] = buf
            }
        }
    }
    return array
}

fun shellSort(array: ArrayList<Int>): ArrayList<Int> {
    var step: Int = array.size / 2
    while (step > 0) {
        for (i in step until array.size) {
            var j = i - step
            while (j >= 0 && array[j] > array[j + step]) {
                val x: Int = array.get(j)
                array[j] = array[j + step]
                array[j + step] = x
                j -= step
            }
        }
        step /= 2
    }
    return array
}