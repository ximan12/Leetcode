public class leetcode236 {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }


    //boolean left = false;

    //boolean right = false;

    TreeNode res = null;

    public boolean recursive(TreeNode node, TreeNode p, TreeNode q) {

        if (node == null) {

            return false;

        }

        //if (node.left != null) {

        int left = recursive(node.left, p, q) ? 1 : 0;

        //}

        //if (node.right != null) {

        int right = recursive(node.right, p, q) ? 1 : 0;

        //}

        int mid = (node == p || node == q) ? 1 : 0;

        if (mid + left + right > 1) {

            res = node;

        }

        return (mid + left + right) > 0;



    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        recursive(root, p, q);

        return res;


    }
}
