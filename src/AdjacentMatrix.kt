import demo.Graph
import demo.Vertex

class AdjacentMatrix(private val numVertices: Int = 0) : Graph {

    private val adjacentMatrix: Array<Array<Int>> = Array(numVertices) { Array(numVertices) { 0 } }


    override fun isSink(): Int {

        var i = 0
        var j = 1

        while (j < numVertices) {
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
            outDegree += adjacentMatrix[sink][k]
        }

        return if (inDegree == adjacentMatrix.size - 1 && outDegree == 0) sink
        else -1

    }

    override fun insetEdge(from: Int, to: Int) {
        adjacentMatrix[from][to] = 1
    }

    override fun dfs(graph: Graph, startingVertex: Int, vertices: List<Vertex>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun toString():String{

        val toString = StringBuilder()

        for (r:Array<Int> in adjacentMatrix){
            for (c:Int in r){
                toString.append("$c ")
            }
            toString.append('\n')
        }

        return toString.toString()

    }
}