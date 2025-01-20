package linked_list

fun main() {
    val node1 = ListNode(2)
    node1.next = ListNode(4)
    node1.next?.next = ListNode(3)
    node1.next?.next?.next = ListNode(7)

    reorderList(node1)
}

fun reorderList(head: ListNode?): Unit {
    val list = mutableListOf<ListNode>()
    var copy = head
    while (copy != null) {
        list.add(copy)
        copy = copy.next
    }

    var start = 0
    var end = list.size - 1

    while (start < end) {
        list[start].next = list[end]
        start++
        if (start >= end) {
            break
        }
        list[end].next = list[start]
        end--
    }
    list[start].next = null
}