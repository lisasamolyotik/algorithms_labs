package by.bsu.graph.draw

import by.bsu.graph.Edge
import by.bsu.graph.Vertex


internal object GraphPanel {
    @JvmStatic
    fun main(args: Array<String>) {
        val frame = GraphDraw("Graph Window")
        frame.setSize(400, 300)
        frame.setVisible(true)
        val v1 = Vertex(1)
        val v2 = Vertex(2)
        val v3 = Vertex(3)
        val v4 = Vertex(4)
        val v5 = Vertex(5)
        frame.addNode(v1, 50, 75)
        frame.addNode(v2, 100, 50)
        frame.addNode(v3, 180, 170)
        frame.addNode(v4, 300, 175)
        frame.addNode(v5, 100, 230)
        frame.addEdge(Edge(5, v1, v2))
        frame.addEdge(Edge(7, v1, v4))
        frame.addEdge(Edge(8, v1, v5))
        frame.addEdge(Edge(10, v2, v4))
        frame.addEdge(Edge(6, v5, v3))
        frame.addEdge(Edge(2, v3, v4))
    }
}