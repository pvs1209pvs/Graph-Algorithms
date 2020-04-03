package demo

import java.util.*
import kotlin.collections.ArrayList

class AdjacentMatrix(input: String) : Graph {

    private var adjacentMatrix = Array(0) { Array(0) { 0 } }
    private val vertices = LinkedList<Vertex>()

    init {
        createGraph(input)
    }

    override fun isSink(): Int {

        var i = 0
        var j = 1

        while (j < vertices.size) {
            if (adjacentMatrix[i][j] == 1) {
                i++
            } else if (adjacentMatrix[i][j] == 0) {
                j++
            }
        }

        val sink: Int = i

        var inDegree: Int = 0
        var outDegree: Int = 0

        for (k in adjacentMatrix.indices) {
            inDegree += adjacentMatrix[k][sink]
            outDegree += adjacentMatrix[k][sink]
        }

        return if (inDegree == adjacentMatrix.size - 1 && outDegree == 0) sink
        else -1


    }

    /* improve with union find */
    override fun prims(source: Int): Array<Int> {

        val edges = LinkedList<Int>()

        val u = HashSet<Vertex>()
        val v = HashSet<Vertex>()

        vertices.forEach { v.add(it) }

        if (v.remove(vertices[source])) u.add(vertices[source])

        while (u.size != vertices.size) {

            val min: Array<Int> = minEdge(u.toTypedArray())

            if (v.remove(vertices[min[0]])) {
                u.add(vertices[min[0]])
                edges.add(min[1])
            }

        }

        return edges.toTypedArray()

    }

    private fun minEdge(u: Array<Vertex>): Array<Int> {

        var minIndex = -1
        var minValue = Int.MAX_VALUE

        for (i in u) {
            for (j in adjacentMatrix[i.id].indices) {
                if (adjacentMatrix[i.id][j] > 0) {
                    if (adjacentMatrix[i.id][j] < minValue && !u.contains(vertices[j])) {
                        minValue = adjacentMatrix[i.id][j]
                        minIndex = j
                    }
                }
            }
        }

        return arrayOf(minIndex, minValue)

    }

    override fun dijkstra(source: Int): Array<Int> {

        val queue = ArrayList<Vertex>()

        val distance = Array(vertices.size) { Int.MAX_VALUE }
        val previous = ArrayList<Vertex>()

        for (i in 0 until vertices.size) {
            queue.add(vertices[i])
        }

        distance[source] = 0

        while (queue.isNotEmpty()) {

            val u = queue.removeAt(minDistance(queue, distance))
            val neighbors = LinkedList<Vertex>()

            /* neighbors of u */
            for (i in 0 until vertices.size) {
                if (adjacentMatrix[u.id][i] > 0) {
                    neighbors.add(vertices[i])
                }
            }

            /* relaxation */
            for (v in neighbors) {
                val alt = distance[u.id] + adjacentMatrix[u.id][v.id]
                if (alt < distance[v.id]) {
                    distance[v.id] = alt
                    if (!previous.contains(v))
                        previous.add(v)
                }
            }

        }

        return distance

    }

    private fun minDistance(queue: List<Vertex>, distance: Array<Int>): Int {

        var arr: Array<Int> = arrayOf()
        for (v in queue) arr += distance[v.id]
        return arr.indexOf(arr.min())

    }

    override fun dfs(s: Int) {
        TODO("not implemented")
    }

    override fun bfs(s: Int) {
        TODO("not implemented")
    }

    override fun floydWarshall(): Array<Array<Int>> {

        val tempGraph = Array(vertices.size) { Array(vertices.size) { Int.MAX_VALUE } }

        for (i in adjacentMatrix.indices) {
            for (j in adjacentMatrix[i].indices) {
                if (adjacentMatrix[i][j] != 0) tempGraph[i][j] = adjacentMatrix[i][j]
                if (i==j) tempGraph[i][j] = 0
            }
        }

        for (i in vertices.indices)
            floydWarshallVertex(i, tempGraph)



        return tempGraph

    }

    private fun floydWarshallVertex(v: Int, graph: Array<Array<Int>>) {

        for (i in vertices.indices) {
            for (j in vertices.indices) {
                if (!(i == v || j == v || graph[i][v] == Int.MAX_VALUE || graph[v][j] == Int.MAX_VALUE)) {
                    val temp = graph[i][v] + graph[v][j]
                    if (temp < graph[i][j]) {
                        graph[i][j] = temp
                    }
                }
            }
        }

    }


    override fun insertEdge(from: Int, to: Int, weight: Int) {
        adjacentMatrix[from][to] = weight
    }

    override fun initGraph(numV: Int, vertexWeights: List<Int>) {
        for (i in 0 until numV) {
            vertices.add(Vertex(i))
            adjacentMatrix = Array(numV) { Array(numV) { 0 } }
        }
    }

    override fun toString(): String {

        val stringForm = StringBuilder()

        for (r in adjacentMatrix) {
            for (c in r) {
                stringForm.append("$c\t")
            }
            stringForm.append('\n')
        }

        return stringForm.toString()

    }

}


