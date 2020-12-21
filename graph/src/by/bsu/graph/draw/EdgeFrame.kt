package by.bsu.graph.draw

import by.bsu.graph.Edge


internal class EdgeFrame(e: Edge) {
    var from: Int
    var to: Int
    var cost: String

    init {
        from = e.fromVertex.value - 1
        to = e.toVertex.value - 1
        cost = e.cost.toString()
    }
}