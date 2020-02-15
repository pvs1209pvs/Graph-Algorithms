package demo

import java.util.*

class AdjacencyList(private val numVertices: Int = 0) : Graph {

    var graph: LinkedList<LinkedList<Vertex>> = LinkedList()
    var vertices: LinkedList<Vertex> = LinkedList()


    init {
        for (i in 0 until numVertices) {
            vertices.add(Vertex(i))
            graph.add(LinkedList())
        }
    }

    override fun dfs(startingVertex: Int) {
        dfs(this, startingVertex, vertices)
    }

    private fun dfs(graph:Graph, startingVertex: Int, vertices: List<Vertex>) {

        vertices[startingVertex].isVisited = true

        for (j in 0 until this.graph[startingVertex].size) {
            if (!this.graph[startingVertex][j].isVisited) {
                println("$startingVertex,${this.graph[startingVertex][j].value} ")
                dfs(graph, this.graph[startingVertex][j].value, vertices)
            } else {
                if (startingVertex < this.graph[startingVertex][j].value) {
                    println("dead $startingVertex,${this.graph[startingVertex][j].value} ")
                    return
                }
            }

        }

    }


    override fun bfs(s: Int, vertices: List<Vertex>) {

        val queue = LinkedList<Vertex>()
        queue.add(vertices[s])

        vertices[s].isVisited = true

        while (!queue.isEmpty()) {

            val v = queue.remove()
            val neighbours = this.graph[v.value]

            for (i in 0 until neighbours.size) {

                val w: Vertex = this.graph[v.value][i]

                if (!w.isVisited) {
                    if (this.graph[w.value].size > 0) {
                        queue.add(w)
                    }
                    w.isVisited = true
                }

            }

        }

    }

    override fun insetEdge(from: Int, to: Int) {
        graph[from].add(vertices[to])
    }

    override fun isSink(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun toString(): String {

        val toString = StringBuilder()

        for (i in 0 until graph.size) {

            toString.append(i)
            toString.append(" ->")

            for (j in 0 until graph[i].size) {
                toString.append(" ${graph[i][j].value}")
            }

            toString.append('\n')

        }

        return toString.toString()

    }

}