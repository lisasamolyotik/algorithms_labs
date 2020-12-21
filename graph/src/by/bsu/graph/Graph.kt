package by.bsu.graph

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap


class Graph {
    var vertexList: MutableList<Vertex> = ArrayList()
    var edgeList: MutableList<Edge> = ArrayList()
    private var vertexIndexes: MutableMap<Vertex, Int> = HashMap()

    constructor(g: Graph) {
        for (v in g.vertexList) {
            vertexList.addAll(g.vertexList)
        }
        edgeList.addAll(g.edgeList)
        generateVertexIndex()
    }

    constructor(vertexList: List<Vertex>, edgeList: List<Edge>) {
        this.vertexList.addAll(vertexList)
        this.edgeList.addAll(edgeList)
        generateVertexIndex()
    }

    constructor(adjacencyMatrix: List<List<Int?>>) {
        for (i in adjacencyMatrix.indices) {
            vertexList.add(Vertex(i))
            for (j in 0 until i) {
                edgeList.add(Edge(adjacencyMatrix[i][j]!!, vertexList[i], vertexList[j]))
            }
        }
        generateVertexIndex()
    }

    fun addVertex(v: Vertex) {
        vertexList.add(v)
        generateVertexIndex()
    }

    fun removeVertex(v: Vertex) {
        for (e in edgeList) {
            val from: Vertex? = e.fromVertex
            val to: Vertex? = e.toVertex
            if (from == v || to == v) {
                edgeList.remove(e)
                break
            }
        }
        vertexList.remove(v)
        generateVertexIndex()
    }

    fun addEdge(e: Edge) {
        edgeList.add(e)
        if (!vertexList.contains(e.fromVertex)) {
            vertexList.add(e.fromVertex)
        } else if (!vertexList.contains(e.toVertex)) {
            vertexList.add(e.toVertex)
        }
        generateVertexIndex()
    }

    fun removeEdge(e: Edge?) {
        edgeList.remove(e)
        generateVertexIndex()
    }

    private fun toAdjacencyList(): List<MutableList<Int>> {
        val adjList = ArrayList<MutableList<Int>>()
        for (i in vertexList.indices) {
            adjList.add(ArrayList())
        }
        for (e in edgeList) {
            val from = getVertexIndex(e.fromVertex)
            val to = getVertexIndex(e.toVertex)
            adjList[from].add(to+1)
            adjList[to].add(from+1)
        }
        return adjList
    }

    private fun toAdjacencyMatrix(): Array<IntArray> {
        val adjMatrix = Array(vertexList.size + 1) { IntArray(vertexList.size + 1) }

        for (row in adjMatrix) {
            Arrays.fill(row, 0)
        }

        for (e in edgeList) {
            val from = getVertexIndex(e.fromVertex)
            val to = getVertexIndex(e.toVertex)
            adjMatrix[from][to] = 1
            adjMatrix[to][from] = 1
        }

        return adjMatrix
    }

    fun dfsSearch() {
        dfs(vertexList[0])
    }

    private fun dfs(start: Vertex) {
        start.visited = true
        print("$start ")
        for (vertex in vertexList.subList(getVertexIndex(start), vertexList.lastIndex)) {
            if (!vertex.visited) {
                dfs(vertex)
            }
        }
    }

    fun printAdjacencyMatrix() {
        val am: Array<IntArray> = toAdjacencyMatrix()
        for (i in 0 until this.vertexList.size) {
            for (j in 0 until this.vertexList.size) {
                print(am[i][j].toString() + " ")
            }
            println()
        }
    }

    fun printAdjacencyList() {
        val al: List<List<Int>> = toAdjacencyList()
        for (i in al.indices) {
            for (j in al[i].indices) {
                print("${al[i][j]} ")
            }
            println()
        }
    }

    fun findMedians() : List<Int> {
        val adjacencyMatrix = toAdjacencyMatrix()
        val ways = mutableListOf<MutableList<Int>>()
        val rez = mutableListOf<Int>()
        val temp = adjacencyMatrix.size + 10

        for (i in adjacencyMatrix.indices) {
            for (j in adjacencyMatrix.indices) {
                if (adjacencyMatrix[i][j] == 0) {
                    adjacencyMatrix[i][j] = temp
                }
            }
        }

        for (i in adjacencyMatrix.indices) {
            ways.add(mutableListOf<Int>())
        }

        for (i in adjacencyMatrix.indices) {
            for (j in adjacencyMatrix.indices) {
                ways[i].add(j)
            }
        }

        for (i in adjacencyMatrix.indices) {
            for (j in adjacencyMatrix.indices) {
                for (k in adjacencyMatrix.indices) {
                    if (adjacencyMatrix[i][k] != temp && adjacencyMatrix[k][j] != temp && adjacencyMatrix[i][k] + adjacencyMatrix[k][j] < adjacencyMatrix[i][j]) {
                        adjacencyMatrix[i][j] = adjacencyMatrix[i][k] + adjacencyMatrix[k][j]
                        ways[i][j] = ways [i][k]
                    }
                }
            }
        }

        var min = adjacencyMatrix.size*adjacencyMatrix.size
        var counter = 0
        for (i in adjacencyMatrix.indices) {
            for (j in adjacencyMatrix.indices) {
                counter += adjacencyMatrix[i][j]
            }
            if (min > counter) {
                min = counter
            }
            counter = 0
        }

        for (i in adjacencyMatrix.indices) {
            for (j in adjacencyMatrix.indices) {
                counter += adjacencyMatrix[i][j]
            }
            if (min == counter) {
                rez.add(i+1)
            }
            counter = 0
        }

        return rez
    }

    fun eulerCycle() : Boolean {
        val al = toAdjacencyList()
        for (v in al) {
            if (v.isEmpty() || v.size % 2 != 0) {
                return false
            }
        }
        return true
    }

    private fun generateVertexIndex() {
        for (i in vertexList.indices) {
            vertexIndexes[vertexList[i]] = i
        }
    }

    private fun getVertexIndex(v: Vertex): Int {
        return vertexIndexes[v] ?: 0
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false
        val simpleGraph = other as Graph
        if (vertexList != simpleGraph.vertexList) return false
        return if (edgeList != simpleGraph.edgeList) false else vertexIndexes == simpleGraph.vertexIndexes
    }

    override fun hashCode(): Int {
        var result = vertexList.hashCode()
        result = 31 * result + edgeList.hashCode()
        result = 31 * result + vertexIndexes.hashCode()
        return result
    }

    override fun toString(): String {
        val builder = StringBuilder()
        for (v in vertexList) builder.append(v.toString())
        return builder.toString()
    }
}