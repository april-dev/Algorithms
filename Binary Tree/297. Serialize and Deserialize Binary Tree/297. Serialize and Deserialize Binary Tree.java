//This code can also used to solve Q449. Serialize and Deserialize BST.
//But a better way to solve Q449 is to use its BST properties.

public class Codec {
    private static final String spliter = ",";
    private static final String NN = "X";
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }
    public void buildString(TreeNode root, StringBuilder sb){
        if (root==null) sb.append(NN + spliter);
        else{
            sb.append(root.val + spliter);
            buildString(root.left, sb);
            buildString(root.right, sb);
        }   
    }
    

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] s = data.split(spliter);
        Queue<String> q = new LinkedList<>();
        for (String cur:s) q.add(cur);
        return buildTree(q);
    }
    public TreeNode buildTree(Queue<String> q){
        String val = q.remove();
        if (val.equals(NN)) return null;
        TreeNode root = new TreeNode(Integer.valueOf(val));
        root.left = buildTree(q);
        root.right = buildTree(q);
        return root;
    }
}
