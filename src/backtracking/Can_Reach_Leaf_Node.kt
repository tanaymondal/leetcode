package backtracking

import java.util.Stack

object Can_Reach_Leaf_Node {
    // problem: In a binary tree, check if there is a path between root node to leaf node without any Zero value node
    // in between

//                1
//            /       \
//        0               3
//      /   \           /   \
//    1       2       0       8

    // Path can be 1, 3, 8

    @JvmStatic
    fun main(args: Array<String>) {
        val root = TreeNode(1)
            .apply {
                this.left = TreeNode(0)
                    .apply {
                        this.left = TreeNode(1)
                        this.right = TreeNode(2)
                    }
                this.right = TreeNode(3)
                    .apply {
                        this.left = TreeNode(0)
                        this.right = TreeNode(8)
                    }
            }

        val stack = Stack<Int>()
        println(canReachLeaf(root, stack))
        println(stack)
    }

    private fun canReachLeaf(root: TreeNode?, stack: Stack<Int>): Boolean {

        if (root != null && root.value == 0) {
            return false
        }

        stack.push(root?.value)
        println(root?.value)

        if (root != null && root.left == null && root.right == null) {
            return true
        }

        if (canReachLeaf(root?.left, stack)) {
            return true
        }
        if (canReachLeaf(root?.right, stack)) {
            return true
        }

        stack.pop()

        return false

    }

    class TreeNode(var value: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}