package demo

interface Graph {

    /**
     * Inserts edge that connects vertex from and to.
     */
    fun insetEdge(from: Int, to: Int)

    /**
     * Performs a simple dfs search on the graph.
     */
    fun dfs(graph:Graph, startingVertex:Int, vertices:List<Vertex>)

}