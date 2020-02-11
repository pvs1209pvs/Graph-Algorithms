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

    fun dfs(startingVertex:Int){
        dfs(graph, startingVertex, vertices)
    }

    override fun dfs(graph: Graph, startingVertex: Int, vertices: List<Vertex>) {

        vertices[startingVertex].isVisited = true

        for (j in 0 until this.graph[startingVertex].size) {
            if (!this.graph[startingVertex][j].isVisited) {
                println("$startingVertex,${this.graph[startingVertex][j].value} ")
                dfs(graph, this.graph[startingVertex][j].value, vertices)
            }

        }

    }

    override fun insetEdge(from: Int, to: Int) {
        graph[from].add(vertices[to])
        graph[to].add(vertices[from])
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