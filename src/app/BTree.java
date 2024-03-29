package app;

/* Class BT */
class BT {
    private BTNode root;

    /* Constructor */
    public BT() {
        root = null;
    }

    /* Function to check if tree is empty */
    public boolean isEmpty() {
        return root == null;
    }

    /* Functions to insert data */
    public void insert(int startV, int endV, Glitch g) {
        root = insert(root, startV, endV, g);
    }

    /* Function to insert data recursively */
    private BTNode insert(BTNode node, int startV, int endV, Glitch g) {
        if (node == null)
            node = new BTNode(startV, endV, g);
        else {
            if (node.getRight() == null)
                node.right = insert(node.right, startV, endV, g);
            else
                node.left = insert(node.left, startV, endV, g);
        }
        return node;
    }

    /* Function to count number of nodes */
    public int countNodes() {
        return countNodes(root);
    }

    /* Function to count number of nodes recursively */
    private int countNodes(BTNode r) {
        if (r == null)
            return 0;
        else {
            int l = 1;
            l += countNodes(r.getLeft());
            l += countNodes(r.getRight());
            return l;
        }
    }

    /* Function to search for an element */
    public boolean search(int valStart, int valEnd) {
        return search(root, valStart, valEnd);
    }

    /* Function to search for an element recursively */
    private boolean search(BTNode r, int start, int end) {
        if (r.getStartValues() == start && r.getEndValues() == end)
            return true;
        if (r.getLeft() != null)
            return search(r.getLeft(), start, end);
        if (r.getRight() != null)
            return search(r.getRight(), start, end);
        return false;
    }

    /* Function for inorder traversal */
    public void inorder() {
        inorder(root);
    }

    private void inorder(BTNode r) {
        if (r != null) {
            inorder(r.getLeft());
            System.out.print(r.getStartValues() + "-" + r.getEndValues()+" ");
            inorder(r.getRight());
        }
    }

    /* Function for preorder traversal */
    public void preorder() {
        preorder(root);
    }

    private void preorder(BTNode r) {
        if (r != null) {
            System.out.print(r.getStartValues() + "-" + r.getEndValues()+" ");
            preorder(r.getLeft());
            preorder(r.getRight());
        }
    }

    /* Function for postorder traversal */
    public void postorder() {
        postorder(root);
    }

    private void postorder(BTNode r) {
        if (r != null) {
            postorder(r.getLeft());
            postorder(r.getRight());
            System.out.print(r.getStartValues() + "-" + r.getEndValues()+" ");
        }
    }
}
/* Class BinaryTree */