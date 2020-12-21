package by.bsu.graph.draw

import by.bsu.graph.Edge
import by.bsu.graph.Vertex
import java.awt.Color
import java.awt.Graphics
import java.util.*
import javax.swing.JFrame


class GraphDraw(title: String?) : JFrame() {
    private val nodes: ArrayList<NodeFrame>
    private val edges: ArrayList<EdgeFrame>
    private var mWidth: Int = 0
    private var mHeight: Int = 0

    fun addNode(vertex: Vertex, x: Int, y: Int) {
        nodes.add(NodeFrame(vertex, x, y))
        this.repaint()
    }

    fun addEdge(e: Edge?) {
        edges.add(EdgeFrame(e!!))
        this.repaint()
    }

    override fun paint(g: Graphics) {
        val f = g.fontMetrics
        val nodeHeight = Math.max(height, f.height)
        g.color = Color.black
        for (e in edges) {
            val xFrom = nodes[e.from].x
            val yFrom = nodes[e.from].y
            val xTo = nodes[e.to].x
            val yTo = nodes[e.to].y
            g.drawLine(xFrom, yFrom, xTo, yTo)
        }
        for (n in nodes) {
            val nodeWidth = Math.max(width, f.stringWidth(n.name) + width / 2)
            g.color = Color.white
            g.fillOval(n.x - nodeWidth / 2, n.y - nodeHeight / 2, nodeWidth, nodeHeight)
            g.color = Color.black
            g.drawOval(n.x - nodeWidth / 2, n.y - nodeHeight / 2, nodeWidth, nodeHeight)
            g.drawString(n.name, n.x - f.stringWidth(n.name) / 2, n.y + f.height / 2)
        }
    }

    init {
        this.title = title
        defaultCloseOperation = EXIT_ON_CLOSE
        nodes = ArrayList()
        edges = ArrayList()
        this.mWidth = 30
        this.mHeight = 30
    }
}