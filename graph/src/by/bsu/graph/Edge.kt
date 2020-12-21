package by.bsu.graph

class Edge(var cost: Int = 0, var fromVertex: Vertex, var toVertex: Vertex) {

    override fun equals(other: Any?): Boolean {
        if (other !is Edge)
            return false
        val costs = cost == other.cost
        if (!costs)
            return false
        val from = fromVertex == other.fromVertex
        if (!from)
            return false
        return toVertex == other.toVertex
    }

    override fun hashCode(): Int {
        val cost = cost * (fromVertex.hashCode() * toVertex.hashCode())
        return 31 * cost
    }

    fun compareTo(e: Edge): Int? {
        if (cost < e.cost) return -1
        if (cost > e.cost) return 1
        val from = e.fromVertex.let { fromVertex.compareTo(it) }
        return if (from != 0) from else e.toVertex.let { toVertex.compareTo(it) }
    }

    override fun toString(): String {
        return """
            [ ${fromVertex.value}] -> [ ${toVertex.value}]
            
            """.trimIndent()
    }

    fun addEdgeFromVertex(): Edge {
        fromVertex.addEdge(this)
        return this
    }
}
