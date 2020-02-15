package demo

class Vertex(var value: Int =-1, var isVisited:Boolean=false) : Comparable<Vertex>{

    override fun compareTo(other: Vertex): Int {
       return this.value.compareTo(other.value)
    }

    override fun toString():String{
        return this.value.toString() + " " + this.isVisited
    }
}