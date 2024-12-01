package tree

import java.util.*
// https://leetcode.com/problems/invert-binary-tree/description/
class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution1 {
    fun invertTree(root: TreeNode?): TreeNode? {

        if (root == null) {
            return null
        }

        val queue: Queue<TreeNode> = LinkedList()
        queue.add(root)


        while (queue.size > 0) {

            val size = queue.size

            for (index in 0 until size) {
                val node = queue.poll()
                val left = node.left
                node.left = node.right
                node.right = left

                node.left?.let {
                    queue.offer(it)
                }
                node.right?.let {
                    queue.offer(it)
                }
            }
        }

        return root
    }
}