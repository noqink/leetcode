import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}

public class Code103_zigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null){
            return null;
        }
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        boolean isReverse = false;
        while (!queue.isEmpty()){
            List<Integer> perhang = new ArrayList<>();
            // 记录每一行的个数
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                 TreeNode peek = queue.poll();
                 if (isReverse){
                     perhang.add(0, peek.val);
                 }else {
                     perhang.add(peek.val);
                 }
                 if (peek.left!=null){
                     queue.add(peek.left);
                 }
                 if (peek.right!=null){
                    queue.add(peek.right);
                 }
            }
            isReverse = !isReverse;
            res.add(perhang);
        }
        return res;
    }
}
