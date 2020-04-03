package demo

import java.util.*

class AdjacencyList(input: String) : Graph {

    private val adjacencyList: LinkedList<LinkedList<Vertex>> = LinkedList()
    private val vertices: LinkedList<Vertex> = LinkedList()
    private val weightedEdges:LinkedList<LinkedList<Int>> = LinkedList()

    init {
        createGraph(input)
    }


    override fun dfs(s: Int) {
        dfs(this, s, vertices)
    }

    private fun dfs(graph: Graph, startingVertex: Int, vertices: List<Vertex>) {

        vertices[startingVertex].isVisited = true

        for (j in 0 until this.adjacencyList[startingVertex].size) {
            if (!this.adjacencyList[startingVertex][j].isVisited) {
                dfs(graph, this.adjacencyList[startingVertex][j].id, vertices)
            } else {
                if (startingVertex < this.adjacencyList[startingVertex][j].id) {
                    return
                }
            }

        }

    }

    override fun bfs(s:Int){
        bfs(s, vertices)
    }


    private fun bfs(s: Int, vertices: List<Vertex>) {

        val queue = LinkedList<Vertex>()
        queue.add(vertices[s])

        vertices[s].isVisited = true

        while (!queue.isEmpty()) {

            val v = queue.remove()
            val neighbours = this.adjacencyList[v.id]

            for (i in 0 until neighbours.size) {

                val w: Vertex = this.adjacencyList[v.id][i]

                if (!w.isVisited) {
                    if (this.adjacencyList[w.id].size > 0) {
                        queue.add(w)
                    }
                    w.isVisited = true
                }

            }

        }

    }

    override fun dijkstra(source: Int): Array<Int> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun prims(source: Int) :Array<Int> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isSink(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun floydWarshall(): Array<Array<Int>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun insertEdge(from: Int, to: Int, weight:Int) {
        adjacencyList[from].add(vertices[to])
        weightedEdges[from].add(weight)
    }

    override fun initGraph(numV: Int, wV: List<Int>) {
        for (i in 0 until numV) {
            vertices.add(Vertex(i))
            adjacencyList.add(LinkedList())
            weightedEdges.add(LinkedList())
        }
    }


    override fun toString(): String {

        val toString = StringBuilder()

        for (i in adjacencyList.indices) {

            toString.append(i)
            toString.append(" -> ")

            for (j in 0 until adjacencyList[i].size) {
                toString.append("${adjacencyList[i][j]},${weightedEdges[i][j]}  ")
            }

            toString.append('\n')

        }

        return toString.toString()

    }

}