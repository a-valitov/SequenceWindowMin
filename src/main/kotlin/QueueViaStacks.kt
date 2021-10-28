class QueueViaStacks<T> {
    var inStack = Stack<T>()
    var outStack = Stack<T>()

    fun pushBack(element: T) {
        inStack.push(element)
    }

    fun popFront() : T? {
        if (!outStack.isEmpty()) return outStack.pop()
        else {
            while(!inStack.isEmpty()) {
                inStack.pop()?.let { outStack.push(it) }
            }
        }

        return outStack.pop()
    }

    override fun toString(): String {
        return inStack.toString() + outStack.toString()
    }

}