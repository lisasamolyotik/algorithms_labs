package by.bsu.graph.draw

import by.bsu.graph.Vertex

internal class NodeFrame(vertex: Vertex, var x: Int, var y: Int) {
    var name: String

    init {
        name = java.lang.String.valueOf(vertex.value)
    }
}