package tree

import java.util.*

// https://leetcode.com/problems/binary-tree-right-side-view/description/
class Solution4 {
    private val queue: Queue<TreeNode> = LinkedList()
    fun rightSideView(root: TreeNode?): List<Int> {
        // basically we need to do BFS and only add right side node on queue

        if (root != null) {
            queue.add(root)
        }

        val finalList = mutableListOf<Int>()
        while (queue.isNotEmpty()) {

            val size = queue.size

            var rightNode: TreeNode? = null
            for (index in 0 until size) {
                val treeNode = queue.poll()
                rightNode = treeNode
                treeNode.left?.let {
                    queue.add(it)
                }
                treeNode.right?.let {
                    queue.add(it)
                }
            }
            finalList.add(rightNode!!.`val`)
        }
        return finalList
    }
}
