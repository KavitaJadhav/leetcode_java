//https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
//| Metric | Complexity |
//| ------ | ---------- |
//| Time   | ❌ O(n²)    |
//| Space  | O(n)       |
//| Stack  | O(h)       |
//
 package patterns.tree;

public class TreePrePostTravel {
    /**
     * Definition for a binary patterns.tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
        private TreeNode build(int[] preOrder, int[] inOrder, int preStart, int preEnd, int inStart, int inEnd){
            if(preStart > preEnd  || inStart > inEnd  ) return null;

            int root = preOrder[preStart];
            int rootIndex = -1;

            for(int index=inStart; index <= inEnd; index++){
                if(inOrder[index]==root){
                    rootIndex = index;
                    break;
                }
            }
            int leftNodeCount = rootIndex - inStart;
            //pre [10, 11, 13, 15, 14, 12, 16, 18, 17]
            // in [15, 13, 11, 14, 10, 18, 16, 12, 17]

            TreeNode left = build(preOrder, inOrder, preStart+1, preStart+leftNodeCount,inStart, rootIndex -1);
            TreeNode right = build(preOrder, inOrder ,preStart+1+leftNodeCount, preEnd ,rootIndex+1 ,inEnd);
            return new TreeNode(root, left, right);

        }

        public TreeNode buildTree(int[] preOrder, int[] inOrder) {
            if(preOrder.length==0 && inOrder.length==0) return null;
            return build(preOrder, inOrder, 0, preOrder.length-1,0, inOrder.length-1 );

        }
    }
