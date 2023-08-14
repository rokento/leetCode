/**
 * 617. 合并二叉树
 * 给你两棵二叉树： root1 和 root2 。
 *
 * 想象一下，当你将其中一棵覆盖到另一棵之上时，两棵树上的一些节点将会重叠（而另一些不会）。你需要将这两棵树合并成一棵新二叉树。合并的规则是：如果两个节点重叠，那么将这两个节点的值相加作为合并后节点的新值；否则，不为 null 的节点将直接作为新二叉树的节点。
 *
 * 返回合并后的二叉树。
 *
 * 注意: 合并过程必须从两个树的根节点开始。
 *
 *输入：root1 = [1,3,2,5], root2 = [2,1,3,null,4,null,7]
 * 输出：[3,4,5,5,4,null,7]
 * 示例 2：
 *
 * 输入：root1 = [1], root2 = [1,2]
 * 输出：[2,2]
 *
 *
 * 提示：
 *
 * 两棵树中的节点数目在范围 [0, 2000] 内
 * -104 <= Node.val <= 104
 */
public class MergeTrees_617 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 != null) {
            root1 = new TreeNode(root2.val);
            root1.left = mergeTrees(null, root2.left);
            root1.right = mergeTrees(null, root2.right);
            return root1;
        }
        if (root1 != null && root2 != null) {
            root1.val = root1.val + root2.val;
            root1.left = mergeTrees(root1.left, root2.left);
            root1.right = mergeTrees(root1.right, root2.right);
        }
        return root1;
    }

    public static void main(String[] args) {
        TreeNode lt2 = new TreeNode(2);
        TreeNode lt4 = new TreeNode(5);
        TreeNode lt3 = new TreeNode(3, lt4, null);
        TreeNode lt1 = new TreeNode(1,lt3, lt2);
        TreeNode lr4 = new TreeNode(7);
        TreeNode lr5 = new TreeNode(4);
        TreeNode lr2 = new TreeNode(3, null, lr4);
        TreeNode lr3 = new TreeNode(1, null, lr5);
        TreeNode lr1 = new TreeNode(2,lr3, lr2);

        MergeTrees_617 m = new MergeTrees_617();
        TreeNode mr = m.mergeTrees(lt1, lr1);
        System.out.println(mr);
    }
}


class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
