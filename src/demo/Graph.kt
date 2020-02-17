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
    fun insetEdge(from: Int, to: Int, weight: Int = 0)

    /**
     * Initializes the graph and the vertices.
     * @param numV is the number of vertices in a graph
     */
    fun initGraph(numV: Int, vertexWeights: List<Int>)

    /**
     * Creates the graph from the file.
     * @param file name of the input file
     */
    fun createGraph(file: String) {

        val inputStreamReader = DataInputStream(FileInputStream(File(file)))

        val n = inputStreamReader.read().toChar().toString().toInt()

        val vertexWeights = ArrayList<Int>(n)

        inputStreamReader.read()

        for (i in 0 until 5) {
            vertexWeights.add(inputStreamReader.read().toChar().toString().toInt())
            inputStreamReader.read()
        }

        initGraph(n, vertexWeights)

//        var from = 0
//        var to = -1
//
//        while (inputStreamReader.available() > 0) {
//
//            val read = inputStreamReader.read().toChar()
//
//            if (read == '\n') {
//                from++
//                to = -1
//            }
//
//            if (read == '0') to++
//
//            if (read == '1') {
//                to++
//                insetEdge(from, to)
//            }
//
//        }

    }

    /**
     * Performs a simple dfs search on the graph.
     * @param s vertex from where the DFS will start.
     */
    fun dfs(s: Int)

    /**
     * Performs a simple bfs on the graph
     * @param s is the starting vertex for the bfs.
     */
    fun bfs(s: Int)

    /**
     * Checks if the graph has a sink.
     * @return the sink vertex.
     */
    fun isSink(): Int

    fun dijkstra(source: Int): Array<Int>


}