package demo

/**
 * @param id uniquely identifies a vertex
 * @param isVisited marks true is vertex has already been visited
 * @param weight is the weight of the vertex
 */
class Vertex(var id: Int = -1, var isVisited: Boolean = false) {

    override fun toString(): String {
        return this.id.toString() + " " + this.isVisited
    }

}