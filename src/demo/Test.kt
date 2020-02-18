package demo

var count: Int = 0

// TODO read graph from file

fun main() {

    val myGraph = AdjacentMatrix(
        "/home/param/Desktop/Kotlin-Projects/Graph-Algorithms/src/demo/graph.txt"
    )

    myGraph.insetEdge(0, 1, 28)
    myGraph.insetEdge(0, 5, 10)

    myGraph.insetEdge(1, 0, 28)
    myGraph.insetEdge(1, 2, 16)
    myGraph.insetEdge(1, 6, 14)

    myGraph.insetEdge(2, 1, 16)
    myGraph.insetEdge(2, 3, 12)

    myGraph.insetEdge(3, 2, 12)
    myGraph.insetEdge(3, 4, 22)
    myGraph.insetEdge(3, 6, 18)

    myGraph.insetEdge(4, 3, 22)
    myGraph.insetEdge(4, 5, 25)
    myGraph.insetEdge(4, 6, 24)

    myGraph.insetEdge(5, 0, 10)
    myGraph.insetEdge(5, 4, 25)

    myGraph.insetEdge(6, 1, 14)
    myGraph.insetEdge(6, 3, 18)
    myGraph.insetEdge(6, 4, 24)



    println(myGraph)

    println(myGraph.prims(0).contentToString())


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