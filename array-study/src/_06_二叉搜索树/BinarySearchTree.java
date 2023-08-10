package _06_二叉搜索树;

public class BinarySearchTree<E extends Comparable<E>> {
    private int size;
    /**
     * 根节点
     */
    private Node<E> root;

    private Comparator<E> comparator;

    public BinarySearchTree(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    private static class Node<E> {
        E element;
        Node<E> left;
        Node<E> right;
        Node<E> parent;

        public Node(E element, Node<E> parent) {
            this.element = element;
            this.parent = parent;
        }
    }

    public int size() {
        return 0;
    }//元素的数量

    public boolean isEmpty() {
        return false;
    }//是否为空

    public void clear() {

    }//清空所有元素

    /**
     * 添加元素
     *
     * @param element
     */
    public void add(E element) {
        elementNotNullCheck(element);
        if (root == null) {
            // 添加第一个节点
            root = new Node<>(element, null);
            size++;
            return;
        }
        // 添加的不是第一个
        // 找父节点
        Node<E> node = root;
        Node<E> parent = null;
        int cmp = 0;
        while (node != null) {
            parent = node;
            // 比较
            cmp = compare(element, node.element);
            if (cmp > 0) {
                // 新增元素较大，则需要那element和node的右节点继续比较
                node = node.right;
            } else if (cmp < 0) {
                // 新增元素较小
                node = node.left;
            } else {
                // 相等
                return;
            }
        }
        // 找到父节点，看看插入的是哪个位置
        if (cmp > 0) {
            parent.right = new Node<>(element, parent);
        } else {
            parent.left = new Node<>(element, parent);
        }
        size++;
    }

    /**
     * 返回值等于0，代表e1和e2相等；返回值大于0，代表e1大于e2：返回值小于于，代表e1小于e2
     *
     * @param e1
     * @param e2
     * @return
     */

    private int compare(E e1, E e2) {
        return e1.compareTo(e2);
    }

    //删除元素
    public void remove(E element) {

    }

    boolean contains(E element) {
        return false;
    }//是否包含某元素

    /**
     * @param element
     */
    private void elementNotNullCheck(E element) {
        if (element == null) {
            throw new IllegalArgumentException("element must not be null");
        }
    }
}
