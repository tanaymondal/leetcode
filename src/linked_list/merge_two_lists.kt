package linked_list

fun main() {
    // list1 = [1,2,4], list2 = [1,3,4]
    val node1 = ListNode(1)
    node1.next = ListNode(2)
    node1.next?.next = ListNode(4)

    val node2 = ListNode(1)
    node2.next = ListNode(3)
    node2.next?.next = ListNode(4)

    var node = mergeTwoLists(node1, node2)

    while (node != null) {
        println(node.`val`)
        node = node.next
    }
}

fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
    var ll1 = list1
    var ll2 = list2
    val result = ListNode(0)
    var current = result

    while (ll1 != null && ll2 != null) {
        if (ll1.`val` > ll2.`val`) {
            current.next = ll2
            ll2 = ll2.next
        } else {
            current.next = ll1
            ll1 = ll1.next
        }
        current = current.next!!
    }

    current.next = ll1 ?: ll2

    return result.next
}