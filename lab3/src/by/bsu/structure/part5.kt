package by.bsu.structure

import kotlin.random.Random


/*
1. Построить двоичное дерево, содержащее n = 12 узлов.
Значения ключей в узлах задавать с помощью датчика случайных
чисел с диапазоном D от 0 до 100.
2. Построить В+ дерево, содержащее n = 12 узлов и имеющее
степень m = 5. Значения ключей в узлах задавать с помощью датчика
случайных чисел с диапазоном D от 0 до 100.
3. Обеспечить обход деревьев «сверху вниз».
4. Выполнить поиск значения ключа по совпадению.
*/

fun main() {
    val n = 12
    val min = 0
    val max = 100
    val tree = BinaryTree()

    for (i in 0..n) {
        tree.add(Random.nextInt(min, max))
    }

    tree.traversePreOrder()

}

class BinaryTree {
    private var root: Node? = null

    private fun addRecursive(current: Node?, value: Int): Node? {
        if (current == null) {
            return Node(value)
        }
        if (value < current.value) {
            current.left = addRecursive(current.left, value)
        } else if (value > current.value) {
            current.right = addRecursive(current.right, value)
        } else {
            // value already exists
            return current
        }
        return current
    }

    fun add(value: Int) {
        root = addRecursive(root, value)!!
    }

    private fun containsNodeRecursive(current: Node?, value: Int): Boolean {
        if (current == null) {
            return false
        }
        if (value == current.value) {
            return true
        }
        return if (value < current.value) containsNodeRecursive(
            current.left,
            value
        ) else containsNodeRecursive(current.right, value)
    }

    fun containsNode(value: Int): Boolean {
        return containsNodeRecursive(root, value)
    }

    fun traversePreOrder(node: Node? = root) {
        if (node != null) {
            print(" " + node.value)
            traversePreOrder(node.left)
            traversePreOrder(node.right)
        }
    }
}

class Node(var value: Int) {
    var left: Node? = null
    var right: Node? = null
}