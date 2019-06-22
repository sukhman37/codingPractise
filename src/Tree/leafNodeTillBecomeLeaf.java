package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class leafNodeTillBecomeLeaf {
    public static void main(String[] args) {
        oNode root = new oNode(8);
        root.left = new oNode(3);
        root.right = new oNode(10);
        root.left.left = new oNode(1);
        //root.left.right = new oNode(6);
        root.right.left = new oNode(14);
        root.right.right = new oNode(4);
        root.left.left.left = new oNode(7);
        root.left.left.right = new oNode(13);
        Map<Integer, List<oNode>> map = new TreeMap<>();
        preorder(root,map);
        printNode(map);

    }

    static void preorder(oNode node, Map<Integer, List<oNode>> map){

        if(node == null)
            return;
        preorder(node.left,map);
        preorder(node.right,map);
        if (node.left == null && node.right == null){
            node.order = 1;
            if(map.containsKey(1)){
                List<oNode> list = map.get(1);
                list.add(node);
            }else{
                List<oNode> list = new ArrayList<>();
                list.add(node);
                map.put(1,list);
            }
        }else{
            int lorder = -1;
            int rorder = -1;
            if (node.left != null){
                lorder = node.left.order;
            }
            if(node.right != null){
                rorder = node.right.order;
            }
            node.order = Math.max(lorder,rorder)+1;
            if(map.containsKey(node.order)){
                List<oNode> list = map.get(node.order);
                list.add(node);
            }else{
                List<oNode> list = new ArrayList<>();
                list.add(node);
                map.put(node.order,list);
            }
        }

    }

    static void printNode(Map<Integer,List<oNode>> map){

        for(Map.Entry<Integer,List<oNode>> entry:map.entrySet()){
            for(oNode list : entry.getValue()){
                System.out.print(list.data+" ");
            }
            System.out.println();
        }
    }

}
class oNode{
    int data;
    oNode left;
    oNode right;
    int order = 0;
    oNode(int data){
        this.data = data;
    }

}
