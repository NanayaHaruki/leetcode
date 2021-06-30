import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {

    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

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
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left=new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node3.left = new TreeNode(4);
        node3.right = new TreeNode(5);
        root.right = node3;
        String str = new Codec1().serialize(root);
        System.out.println(str);
        TreeNode node = new Codec1().deserialize(str);
        System.out.println(node);
    }
    public static class Codec1 {
        public String serialize(TreeNode root) {
            return rserialize(root, "");
        }

        public TreeNode deserialize(String data) {
            String[] dataArray = data.split(",");
            List<String> dataList = new LinkedList<String>(Arrays.asList(dataArray));
            return rdeserialize(dataList);
        }

        public String rserialize(TreeNode root, String str) {
            if (root == null) {
                str += "None,";
            } else {
                str += root.val + ",";
                str = rserialize(root.left, str);
                str = rserialize(root.right, str);
            }
            return str;
        }

        public TreeNode rdeserialize(List<String> dataList) {
            if (dataList.get(0).equals("None")) {
                dataList.remove(0);
                return null;
            }

            TreeNode root = new TreeNode(Integer.valueOf(dataList.get(0)));
            dataList.remove(0);
            root.left = rdeserialize(dataList);
            root.right = rdeserialize(dataList);

            return root;
        }
    }


}
