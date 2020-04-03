package demo

import java.util.*

var count: Int = 0

// TODO read graph from file

fun main() {

    val myGraph = AdjacentMatrix(
        "/home/param/Desktop/Kotlin Projects/Graph-Algorithms/src/demo/graph.txt"
    )

    myGraph.insertEdge(0,1,1);
    myGraph.insertEdge(0,5,1);

    myGraph.insertEdge(1,0,1);
    myGraph.insertEdge(1,2,3);
    myGraph.insertEdge(1,6,1);

    myGraph.insertEdge(2,1,3);
    myGraph.insertEdge(2,3,2);
    myGraph.insertEdge(2,7,2);

    myGraph.insertEdge(3,2,2);
    myGraph.insertEdge(3,4,1);

    myGraph.insertEdge(4,3,1);
    myGraph.insertEdge(4,5,3);
    myGraph.insertEdge(4,7,1);

    myGraph.insertEdge(5,0,1);
    myGraph.insertEdge(5,4,3);
    myGraph.insertEdge(5,6,4);

    myGraph.insertEdge(6,1,1);
    myGraph.insertEdge(6,5,4);
    myGraph.insertEdge(6,7,1);

    myGraph.insertEdge(7,2,2);
    myGraph.insertEdge(7,4,1);
    myGraph.insertEdge(7,6,1);


    val arr = myGraph.floydWarshall()







}

