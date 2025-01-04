package linked_list

fun main() {
    // l1 = [2,4,3], l2 = [5,6,4]
    val node1 = ListNode(2)
    node1.next = ListNode(4)
    node1.next?.next = ListNode(3)

    val node2 = ListNode(5)
    node2.next = ListNode(6)
    node2.next?.next = ListNode(4)

    var node = addTwoNumbers(node1, node2)

    while (node != null) {
        println(node.`val`)
        node = node.next
    }
}

fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {

    var ll1 = l1
    var ll2 = l2
    val result = ListNode(0)
    var current = result
    var carry = 0

    while (ll1 != null || ll2 != null || carry != 0) {
        val value1 = ll1?.`val` ?: 0
        val value2 = ll2?.`val` ?: 0

        val sum = value1 + value2 + carry
        val num = sum % 10
        carry = sum / 10

        current.next = ListNode(num)
        current = current.next!!
        ll1 = ll1?.next
        ll2 = ll2?.next
    }

    return result.next

}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}