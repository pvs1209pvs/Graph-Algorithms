package demo

import java.lang.System.exit

var count: Int = 0

/*
0,1
1,2
2,3
3,4
4,5
 */

fun main() {


    val arr:Array<Int> = Array(5){0}
    arr[0] = 10
    arr[1] = 10
    arr[2] = 10
    arr[3] = 10
    println(arr.contentToString())
    exit(0)

    val myGraph = AdjacencyList(6)

    //a=0, b=1, c=2, d=3, e=4, f=5, g=6, h=7

    myGraph.insetEdge(0, 1)
    myGraph.insetEdge(0, 2)

    myGraph.insetEdge(1, 3)

    // c->f,g
    myGraph.insetEdge(2, 3)
    myGraph.insetEdge(2, 4)

    // e->h
    myGraph.insetEdge(3, 5)

    println(myGraph)

    myGraph.bfs(0, myGraph.vertices)

    println(myGraph.vertices)


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