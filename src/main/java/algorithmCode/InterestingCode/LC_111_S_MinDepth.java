package algorithmCode.InterestingCode;

import algorithmCode.InterestingCode.entity.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 111.二叉树的最小深度
 *
 * @author bc
 * @date 2022/12/13 19:40
 */
public class LC_111_S_MinDepth {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 1;
        //遍历队列
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) return depth;

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            depth++;
        }
        return depth;
    }
}
