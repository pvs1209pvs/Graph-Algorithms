package demo

import java.io.InputStream
import java.util.*

class AdjacentMatrix(input:String) : Graph {

    private var adjacentMatrix: Array<Array<Int>> = Array(0) { Array(0) { 0 } }
    private val vertices = LinkedList<Vertex>()

    init{
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
            outDegree += adjacentMatrix[sink][k]
        }

        return if (inDegree == adjacentMatrix.size - 1 && outDegree == 0) sink
        else -1

    }

    override fun insetEdge(from: Int, to: Int) {
        adjacentMatrix[from][to] = 1
    }

    override fun dfs(startingVertex: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun bfs(s: Int, vertices: List<Vertex>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

//     fun createGraph(input: String) {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }

    override fun initGraph(numV: Int) {
       for  (i in 0 until numV){
           vertices.add(Vertex(i))
           adjacentMatrix = Array(numV) { Array(numV) { 0 } }
       }
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