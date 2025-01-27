package linked_list

// https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
fun main() {
    val node1 = ListNode(1)
    node1.next = ListNode(2)
    node1.next?.next = ListNode(3)
    node1.next?.next?.next = ListNode(4)
    node1.next?.next?.next?.next = ListNode(5)

    var node = removeNthFromEnd(node1, 2)
    while (node != null) {
       println(node.`val`)
       node = node.next
    }
}

fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
    val dummy = ListNode(0)
    dummy.next = head

    var right: ListNode? = head
    var left: ListNode? = dummy

    for (i in 0 until n) {
        right = right?.next
    }

    while (right != null) {
        left = left?.next
        right = right.next
    }

    left?.next = left?.next?.next

    return dummy.next
}