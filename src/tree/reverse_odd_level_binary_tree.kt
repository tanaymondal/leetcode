package tree

import java.util.*

// https://leetcode.com/problems/reverse-odd-levels-of-binary-tree/description/
class Solution3 {
    fun reverseOddLevels(root: TreeNode?): TreeNode? {

        if (root == null) {
            return null
        }

        val queue: Queue<TreeNode> = LinkedList()
        queue.add(root)

        var level = 0
        while (queue.size > 0) {

            val size = queue.size

            val list = mutableListOf<TreeNode>()
            for (index in 0 until size) {
                val node = queue.poll()

                node.left?.let {
                    queue.add(it)
                }
                node.right?.let {
                    queue.add(it)
                }
                if(level % 2 == 1) {
                    list.add(node)
                }
            }

            if(list.isNotEmpty()) {
                var startIndex = 0
                var endIndex = list.size - 1

                while(startIndex < endIndex) {
                    val temp = list[startIndex].`val`
                    list[startIndex].`val` = list[endIndex].`val`
                    list[endIndex].`val` = temp
                    startIndex++
                    endIndex--
                }
            }
            level++
        }
        return root
    }
}