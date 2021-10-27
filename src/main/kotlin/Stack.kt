class Stack<T> {
    private val stackElements = ArrayList<T>()

    //adds an element to the stack
    fun push(element: T) {
        stackElements.add(element)
    }

    //removes the most recently added element OR null if there's no elements in stack
    fun pop() : T? {
        return if (stackElements.isEmpty()) null else stackElements.last().also { stackElements.removeLast() }
    }

    fun isEmpty() : Boolean = stackElements.isEmpty()

    override fun toString() : String = stackElements.toString()
}