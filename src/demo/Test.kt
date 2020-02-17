package demo

var count: Int = 0

// TODO read graph from file

fun main() {

    val myGraph = AdjacentMatrix(
        "/home/param/Desktop/Kotlin-Projects/Graph-Algorithms/src/demo/graph.txt"
    )

//    myGraph.insetEdge(0,1,2)
//    myGraph.insetEdge(0,2,4)
//
//    myGraph.insetEdge(1,2, 1)
//    myGraph.insetEdge(1,3, 7)
//
//    myGraph.insetEdge(2, 4, 3)
//
//    myGraph.insetEdge(3, 5, 1)
//
//    myGraph.insetEdge(4, 3, 2)
//    myGraph.insetEdge(4, 5, 5)

    println(myGraph)


}

//fun dfs(graph: LinkedList<LinkedList<Vertex>>, v: Int, vertices: LinkedList<Vertex>): Int {
//
//    vertices[v].isVisited = true
//
//    for (j in 0 until graph[v].size) {
//        if (!graph[v][j].isVisited) {
//            println("$v,${graph[v][j].value} ")
//            count++
//            dfs(graph, graph[v][j].value, vertices)
//        } else {
//            if (v < graph[v][j].value) {
//                return ++count
//            }
//        }
//
//    }
//
//    return count
//
//}
//
//fun printGraph(graph: LinkedList<LinkedList<Vertex>>) {
//    println()
//    for (i in 0 until graph.size) {
//        print("$i -> ")
//        for (j in 0 until graph[i].size) {
//            print("${graph[i].get(j).value} ")
//        }
//        println()
//    }
//    println()
//}