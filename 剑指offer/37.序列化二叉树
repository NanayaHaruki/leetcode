    public class Codec {
        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            return rserialize(root, "");
        }

        private String rserialize(TreeNode node,String str){
            if (node==null){
                str += "null,";
            }else {
                str += (String.format("%d,",node.val));
                str = rserialize(node.left,str);//左树被拼接上去了
                str = rserialize(node.right,str); // 右树拼接
            }
            return str;
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String[] split = data.split(",");
            LinkedList<String> list = new LinkedList<String>(Arrays.asList(split));
            return rdeserialize(list);
        }

        private TreeNode rdeserialize(LinkedList<String> data) {
            String str = data.removeFirst();
            if (str.equals("null")) {
                return null;
            }
            TreeNode node = new TreeNode(Integer.parseInt(str));
            node.left = rdeserialize(data);
            node.right = rdeserialize(data);
            return node;
        }
    }