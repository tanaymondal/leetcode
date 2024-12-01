package tree

import java.util.*

// https://leetcode.com/problems/binary-tree-level-order-traversal/
class Solution2 {
    private val queue: Queue<TreeNode> = LinkedList()
    private val list = mutableListOf<List<Int>>()
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        // basically we need to do BFS

        if (root != null) {
            queue.add(root)
        }

        while (queue.isNotEmpty()) {

            val size = queue.size

            val l = mutableListOf<Int>()
            for (index in 0 until size) {
                val treeNode = queue.poll()
                l.add(treeNode.`val`)
                treeNode.left?.let {
                    queue.add(it)
                }
                treeNode.right?.let {
                    queue.add(it)
                }
            }
            list.add(l)
        }
        return list
    }
}