package jobdu.binarytree;

public class GetPostFromPreAndMid {

    public static int[] pre = {4,2,6,3,1,5};
    public static int[] mid = {6,2,3,4,1,5};

    public static void main(String[] args) {
        int length = pre.length;
        Node root = build(0,5,0,5);
        postOrder(root);
    }

    /*由先序、中序确定二叉树*/
    public static Node build(int pre_start,int pre_end,int mid_start,int mid_end){

        Node root = new Node();
        root.value =pre[pre_start];

        int rootInMid = -1;
        for (int i = mid_start; i <= mid_end; i++) {
            if (mid[i] == pre[pre_start]) {
                rootInMid = i;
                break;
            }
        }

        if (rootInMid != mid_start) {
            root.lchild = build(pre_start+1,pre_start + (rootInMid - mid_start),mid_start,rootInMid-1);
        }
        if (rootInMid != mid_end) {
            root.rchild = build(pre_start + (rootInMid - mid_start) + 1,pre_end,rootInMid + 1,mid_end);
        }


        return root;
    }

    static void postOrder(Node node) {

        if (node.lchild != null) {
            postOrder(node.lchild);
        }
        if (node.rchild != null) {
            postOrder(node.rchild);
        }
        System.out.print(node.value + " ");
    }

}

class Node{
    public int value;
    public Node lchild = null;
    public Node rchild = null;
}


