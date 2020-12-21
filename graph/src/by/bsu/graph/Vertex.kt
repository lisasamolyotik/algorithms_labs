package by.bsu.graph

class Vertex(var value: Int = 0) {
    val edges: MutableList<Edge> = ArrayList()

    var visited = false

    fun addEdge(e: Edge) {
        edges.add(e)
    }

    fun getEdge(v: Vertex): Edge? {
        for (e in edges) {
            if (e.toVertex == v) return e
        }
        return null
    }

    override fun hashCode(): Int {
        val code: Int = value + edges.size
        return 31 * code
    }

    override fun equals(other: Any?): Boolean {
        if (other !is Vertex) return false
        val edgesSizeEquals = edges.size == other.edges.size
        if (!edgesSizeEquals) return false
        val iter1 = edges.iterator()
        val iter2 = other.edges.iterator()
        while (iter1.hasNext() && iter2.hasNext()) {
            val e1 = iter1.next()
            val e2 = iter2.next()
            if (e1.cost != e2.cost) return false
        }
        return true
    }

    operator fun compareTo(v: Vertex): Int {
        val valueComp = if (this.value == v.value) 1 else -1
        if (valueComp != 0) return valueComp
        if (edges.size < v.edges.size) return -1
        if (edges.size > v.edges.size) return 1
        val iter1 = edges.iterator()
        val iter2 = v.edges.iterator()
        while (iter1.hasNext() && iter2.hasNext()) {
            // Only checking the cost
            val e1 = iter1.next()
            val e2 = iter2.next()
            if (e1.cost < e2.cost) return -1
            if (e1.cost > e2.cost) return 1
        }
        return 0
    }

    override fun toString(): String {
        val builder = StringBuilder()
        builder.append("Value=").append(value).append("\n")
        for (e in edges) builder.append("\t").append(e.toString())
        return builder.toString()
    }
}

