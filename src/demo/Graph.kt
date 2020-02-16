package demo

import java.io.DataInputStream
import java.io.File
import java.io.FileInputStream

interface Graph {

    /**
     * Inserts edge that connects vertex from and to.
     * @param from is the source vertex
     * @param to is the destination vertex
     */
    fun insetEdge(from: Int, to: Int)

    /**
     * Performs a simple dfs search on the graph.
     * @param graph
     * @param startingVertex vertex from where the DFS will start.
     * @param vertices all the vertices of the graph
     */
    //fun dfs(graph:Graph, startingVertex:Int, vertices:List<Vertex>)

    fun dfs(startingVertex: Int)

    fun bfs(s: Int, vertices: List<Vertex>)
    /**
     * Checks if the graph has a sink.
     * @return the sink vertex.
     */
    fun isSink(): Int

    fun initGraph(numV: Int)

    fun createGraph(input: String) {
        val inputStreamReader = DataInputStream(FileInputStream(File(input)))

        val n = inputStreamReader.read().toChar().toString().toInt()

        initGraph(n)

        var from = -1
        var to = 0

        while (inputStreamReader.available() > 0) {

            val read = inputStreamReader.read().toChar()

            if (read == '\n') {
                from++
                to = -1
            }

            if (read == '0') to++

            if (read == '1') {
                to++
                insetEdge(from, to)
            }

        }
    }
}