package by.bsu.graph

import java.util.*

fun main() {
    val graph = createGraph()

    println("Adjacency matrix:")
    graph.printAdjacencyMatrix()

    println("Adjacency list:")
    graph.printAdjacencyList()

    println("Edge list:")
    println(graph.edgeList.toString() + "\n")

    println("Deep first search: ")

    graph.dfsSearch()

    println("Graph has euler cycle: ${graph.eulerCycle()}")

    println("Medians list: ${graph.findMedians()}")

    val euler = createEulerGraph()

    println("Adjacency matrix:")
    euler.printAdjacencyMatrix()

    println("Adjacency list:")
    euler.printAdjacencyList()

    println("Edge list:")
    println(euler.edgeList.toString() + "\n")

    println("Deep first search: ")

    euler.dfsSearch()

    println("Graph has euler cycle: ${euler.eulerCycle()}")

    println("Medians list: ${euler.findMedians()}")
}

fun createGraph(): Graph {
    val vertices: MutableList<Vertex> = ArrayList()
    val v1 = Vertex(1)
    vertices.add(v1)
    val v2 = Vertex(2)
    vertices.add(v2)
    val v3 = Vertex(3)
    vertices.add(v3)
    val v4 = Vertex(4)
    vertices.add(v4)
    val v5 = Vertex(5)
    vertices.add(v5)
    val v6 = Vertex(6)
    vertices.add(v6)

    val edges: MutableList<Edge> = ArrayList()
    val e1 = Edge(5, v1, v2).addEdgeFromVertex()
    edges.add(e1)
    val e2 = Edge(10, v2, v4).addEdgeFromVertex()
    edges.add(e2)
    val e3 = Edge(7, v1, v4).addEdgeFromVertex()
    edges.add(e3)
    val e4 = Edge(8, v1, v5).addEdgeFromVertex()
    edges.add(e4)
    val e5 = Edge(6, v5, v3).addEdgeFromVertex()
    edges.add(e5)
    val e6 = Edge(2, v3, v4).addEdgeFromVertex()
    edges.add(e6)
    val e7 = Edge(10, v3, v6).addEdgeFromVertex()
    edges.add(e7)

    return Graph(vertices, edges)
}

fun createEulerGraph(): Graph {
    val vertices: MutableList<Vertex> = ArrayList()
    val v1 = Vertex(1)
    vertices.add(v1)
    val v2 = Vertex(2)
    vertices.add(v2)
    val v3 = Vertex(3)
    vertices.add(v3)
    val v4 = Vertex(4)
    vertices.add(v4)
    val v5 = Vertex(5)
    vertices.add(v5)

    val edges: MutableList<Edge> = ArrayList()
    edges.add(Edge(1, v1, v2).addEdgeFromVertex())
    edges.add(Edge(1, v1, v3).addEdgeFromVertex())
    edges.add(Edge(1, v1, v4).addEdgeFromVertex())
    edges.add(Edge(1, v1, v5).addEdgeFromVertex())
    edges.add(Edge(1, v2, v3).addEdgeFromVertex())
    edges.add(Edge(1, v2, v4).addEdgeFromVertex())
    edges.add(Edge(1, v2, v5).addEdgeFromVertex())
    edges.add(Edge(1, v3, v4).addEdgeFromVertex())
    edges.add(Edge(1, v3, v5).addEdgeFromVertex())
    edges.add(Edge(1, v4, v5).addEdgeFromVertex())

    return Graph(vertices, edges)
}