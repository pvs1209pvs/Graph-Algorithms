package demo

import java.util.*
import kotlin.collections.ArrayList

class AdjacentMatrix(input: String) : Graph {

    private var adjacentMatrix = Array(0) { Array(0) { 0 } }
    val vertices = LinkedList<Vertex>()

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

            // neighbors of u
            for (i in 0 until vertices.size) {
                if (adjacentMatrix[u.id][i] > 0) {
                    neighbors.add(vertices[i])
                }
            }

            // relaxation
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

        for (v in queue){
            arr += distance[v.id]
        }

        return arr.indexOf(arr.min())

    }

    override fun dfs(s: Int) {
        TODO("not implemented")
    }

    override fun bfs(s: Int) {
        TODO("not implemented")
    }

    override fun insetEdge(from: Int, to: Int, weight: Int) {
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


