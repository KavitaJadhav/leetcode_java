//https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
//Time Complexity:
//Serialize → O(n)
//Deserialize → O(n)

//Space Complexity:
//O(n) for storing values
//O(h) recursion patterns.stack
//Worst case → O(n)
//Balanced → O(log n)

package patterns.tree;

/**
 * Definition for a binary patterns.tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.*;
public class SerializeDeserialize {
    private int index = 0;
    private void dfs_serialize(TreeNode node, List<String> result){
        if(node==null) {
            result.add("N");
            return ;
        }

        result.add(String.valueOf(node.val));

        dfs_serialize(node.left, result);
        dfs_serialize(node.right, result);
    }


    private TreeNode dfs_deserialize(List<String> data){
        String indexData = data.get(index);
        if(indexData.equals("N")){
            index += 1;
            return null;
        }else{
            TreeNode node = new TreeNode(Integer.parseInt(indexData));
            index += 1;
            node.left = dfs_deserialize(data);
            node.right = dfs_deserialize(data);
            return node;

        }
    }
    // Encodes a patterns.tree to a single string.
    public String serialize(TreeNode root) {
        List<String> result = new ArrayList<>();

        dfs_serialize(root, result);
        return String.join(",", result);

    }

    // Decodes your encoded data to patterns.tree.
    public TreeNode deserialize(String data) {
        index = 0;
        List<String> splitData = Arrays.asList(data.split(","));
        return dfs_deserialize(splitData);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));