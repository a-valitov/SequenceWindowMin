open class Stack<T> {
    private val stackElements = ArrayList<T>()

    //adds an element to the stack
    open fun push(element: T) {
        stackElements.add(element)
    }

    //removes the most recently added element OR null if there's no elements in stack
    open fun pop() : T? {
        return if (stackElements.isEmpty()) null else stackElements.last().also { stackElements.removeLast() }
    }

    fun isEmpty() : Boolean = stackElements.isEmpty()
    fun getSize() : Int = stackElements.size

    override fun toString() : String = "Stack: ${stackElements.toString()}"
}


class StackWithMin: Stack<Int>() {
    private var minElements = ArrayList<Int>()

    override fun push(element: Int) {
        super.push(element)
        if (minElements.isEmpty()) minElements.add(element)
            else if (element < minElements.last()) minElements.add(element)
                else minElements.add(minElements.last())
    }

    override fun pop() : Int? {
        if (this.isEmpty()) return null
        minElements.removeLast()
        return super.pop()
    }

    fun currentMin() : Int? {
        return if (minElements.isEmpty()) null else minElements.last()
    }

    override fun toString() : String = super.toString() + "\n" + "Minis: " + minElements.toString()
}

