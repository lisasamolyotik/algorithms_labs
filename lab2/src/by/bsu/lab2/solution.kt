package by.bsu.lab2

import java.lang.Integer.min

fun main() {
    println(
        """
            |Время выполнения программного ресурса составляет величину $T
            |число процессов $n, $p
            |число копий $c
        """.trimMargin()
    )
    println("Минимальное общее время заданных объемов вычислений ${minTime()}")
    println("Достаточное число процессоров ${p0()}")
    println("Минимальное число процессоров ${p1()}")

}

const val n = 100
const val p = 10
const val c = 5
val T = arrayOf(4, 2, 5, 2)

//минимальное общее время задаееых объемов вычислений
fun minTime() = (n / min(p, c)) * T.sum()

//достаточное число процессоров
fun p0() = min(p, c)

//минимальное число процессоров
fun p1() = n / p0()