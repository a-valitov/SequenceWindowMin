import kotlin.random.Random
import kotlin.reflect.typeOf

fun main() {

    val inputArray = arrayOf(6, 2, 4, 3, 5, 8, 5, 6, 7, 3)

    //val queue = QueueViaStacks<Int>()

    val stackMin = StackWithMin()

    for(elem in inputArray) stackMin.push(elem)
    println(stackMin.toString())
    stackMin.pop()
    println(stackMin.toString())
    stackMin.pop()
    println(stackMin.toString())
    stackMin.pop()
    println(stackMin.toString())
    stackMin.pop()
    println(stackMin.toString())

//
//    val inputArray = Array<Int>(Random.nextInt(10, 20)) { Random.nextInt(1, 100)}
//
//    val windowSize = 3
//
//    println("The size of Input Array: ${inputArray.size}")
//    println("The size of Window: $windowSize")
//    println("Input Array: ${inputArray.joinToString()}")
//    println("Local minis: ${findLocalMinWithWindow(inputArray, windowSize).first.joinToString()}")
//    println("Operations: (${inputArray.size} + 1 - $windowSize) * $windowSize = ${findLocalMinWithWindow(inputArray, windowSize).second}")

}

fun findLocalMinWithWindow(inputArray: Array<Int>, windowSize: Int): Pair<Array<Int>, Int> {
    var operationsCount = 0
    val minArraySize = (inputArray.size + 1) - windowSize
    if (minArraySize <= 0) return Pair(arrayOf(), 0)

    val minArray = Array<Int>(minArraySize) { 0 }
    //println(minArray.joinToString())

    for (i in 0 until inputArray.size-windowSize+1) {
        var localMin = Int.MAX_VALUE
        for (j in i until i+windowSize) {
            operationsCount++
            if (inputArray[j] < localMin) localMin = inputArray[j]
        }
        minArray[i] = localMin
    }

    return Pair(minArray, operationsCount)
}