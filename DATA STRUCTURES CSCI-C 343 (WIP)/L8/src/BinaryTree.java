import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class BinaryTree<E> {
    private final E data;
    private BinaryTree<E> left;
    private BinaryTree<E> right;

    /**
     * Create a binary tree with the given data, left, and right branches.
     *
     * @param data  Data to store in this node
     * @param left  Left branch of this node, pass {@code null} if this branch is empty
     * @param right Right branch of this node, pass {@code null} if this branch is empty
     */
    public BinaryTree(E data, BinaryTree<E> left, BinaryTree<E> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    /**
     * Create a binary tree with the given data and no child nodes.
     *
     * @param data Data to store in this node
     */
    public BinaryTree(E data) {
        this(data, null, null);
    }

    public E getData() {
        return data;
    }

    public BinaryTree<E> getLeft() {
        return left;
    }

    public void setLeft(BinaryTree<E> left) {
        this.left = left;
    }

    public BinaryTree<E> getRight() {
        return right;
    }

    public void setRight(BinaryTree<E> right) {
        this.right = right;
    }


    /**
     * Returns whether this object and the given other object are equal. Compare the root node and recursively verify
     * that their left and right subtrees are identical. Both trees must have the same structure at each corresponding
     * node.
     *
     * @param other A binary tree to compare equality to
     * @return True if the trees are identical, false otherwise
     */
    public boolean dfsEquals(BinaryTree<E> other) {
        return dfsEqualsHelper(this, other);
    }

    private static <T> boolean dfsEqualsHelper(BinaryTree<T> a, BinaryTree<T> b) {
        if (a == b) {
            return true;
        }
        if (a == null || b == null) {
            return false;
        }

        return a.data.equals(b.data) && dfsEqualsHelper(a.left, b.left) && dfsEqualsHelper(a.right, b.right);
    }

    /**
     * Returns whether this object and the given other object are equal. Use two queues to maintain the traversal order.
     * Both trees must have the same structure at each corresponding node.
     *
     * @param other A binary tree to compare equality to
     * @return True if the trees are identical, false otherwise
     */
    public boolean bfsEquals(BinaryTree<E> other) {
        if (this == other) {
            return true;
        }
        if (other == null) {
            return false;
        }

        Queue<BinaryTree<E>> q1 = new LinkedList<>();
        Queue<BinaryTree<E>> q2 = new LinkedList<>();
        q1.add(this);
        q2.add(other);

        while (!q1.isEmpty() && !q2.isEmpty()) {
            BinaryTree<E> n1 = q1.remove();
            BinaryTree<E> n2 = q2.remove();

            if (!n1.data.equals(n2.data)) {
                return false;
            }

            if ((n1.left == null) != (n2.left == null)) {
                return false;
            }
            if (n1.left != null) {
                q1.add(n1.left);
                q2.add(n2.left);
            }

            if ((n1.right == null) != (n2.right == null)) {
                return false;
            }
            if (n1.right != null) {
                q1.add(n1.right);
                q2.add(n2.right);
            }
        }

        return q1.isEmpty() && q2.isEmpty();
    }

    /**
     * Returns whether this object and the given other object are equal. Use Morris traversal to efficiently traverse
     * two binary trees without using recursions. Both trees must have the same structure at each corresponding node.
     *
     * @param other A binary tree to compare equality to
     * @return True if the trees are identical, false otherwise
     */
    public boolean morrisEquals(BinaryTree<E> other) {
        if (other == null) {
            return false;
        }
        if (this == other) {
            return true;
        }

        BinaryTree<E> t1 = this;
        BinaryTree<E> t2 = other;

        // it is extremely important that both traversals finish so that
        // the trees passed to this function are not modified by returning early
        boolean r = true;

        // while either traversal is valid
        while (t1 != null || t2 != null) {
            // if one traversal finishes they're not equal
            if (t1 == null || t2 == null) {
                r = false;
            }

            // if both traversals are still valid check equality
            if (t1 != null && t2 != null && t1.data != t2.data) {
                r = false;
            }

            // traverse second tree
            t1 = morrisTraversal(t1);
            // traverse second tree
            t2 = morrisTraversal(t2);
        }

        return r;
    }

    private BinaryTree<E> morrisTraversal(BinaryTree<E> t) {
        if (t != null) {
            // if left is null, go to right
            if (t.left == null) {
                return t.right;
            } else {
                // find in-order predecessor
                BinaryTree<E> pred = t.left;
                while (pred.right != null && pred.right != t) {
                    pred = pred.right;
                }

                // temporary link
                if (pred.right == null) {
                    pred.right = t;
                    return t.left;
                }

                // remove link
                pred.right = null;
                return t.right;
            }
        }
        return t;
    }

}