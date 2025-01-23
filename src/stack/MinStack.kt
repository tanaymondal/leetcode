package stack

fun main() {
    val stack = MinStackNode()
    stack.push(5)
    stack.push(1)
    stack.push(7)
    println(stack.getMin())
    stack.pop()
    println(stack.getMin())
    stack.pop()
    println(stack.getMin())
}

class MinStack {

    val stack = ArrayDeque<Int>()
    val minStack = ArrayDeque<Int>()

    fun push(`val`: Int) {
        stack.addLast(`val`)
        val min = if (minStack.isEmpty()) `val` else minOf(minStack.last(), `val`)
        minStack.addLast(min)
    }

    fun pop() {
        if (stack.isEmpty()) return
        stack.removeLast()
        minStack.removeLast()
    }

    fun top(): Int {
        return stack.last()
    }

    fun getMin(): Int {
        return minStack.last()
    }

}

class MinStackNode {

    private var top: Node? = null

    fun push(`val`: Int) {
        val min = top?.let {
            minOf(it.minimum, `val`)
        } ?: `val`

        val node = Node(`val`, min)
        node.next = top
        top = node
    }

    fun pop() {
        top = top?.next
    }

    fun top(): Int {
        return top?.value ?: throw IllegalStateException("Stack is empty")
    }

    fun getMin(): Int {
        return top?.minimum ?: throw IllegalStateException("Stack is empty")
    }

    data class Node(
        val value: Int,
        val minimum: Int,
        var next: Node? = null
    )
}