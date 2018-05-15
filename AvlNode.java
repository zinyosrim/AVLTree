/**
 *
 * Generic implematation for an AVL Tree node
 * @param <K> Class for key
 * @param <V> Class for value
 *
 */
public class AvlNode<K, V>  {

    private AvlNode<K, V> left, right, parent;

    private int height = 1;

    private K key;

    private V value;

    public AvlNode(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public V getValue() {
        return value; }

    public void setValue(V value) {
        this.value = value;
    }

    public AvlNode<K, V> getRight() {
        if (this != null) {
            return right;

        } else {
            return null;
        }
    }

    public void setRight(AvlNode<K, V> node) {
        this.right = node;
        if (this != null && node != null) node.parent = this;
    }

    public AvlNode<K, V> getLeft() {
        if (this != null) {
            return left;

        } else {
            return null;
        }
    }

    public void setLeft(AvlNode<K, V> node) {
        this.left = node;
        if (this != null && node != null) node.parent = this;
    }

    public AvlNode<K, V> getParent() {
        return parent;
    }

    public void setParent(AvlNode<K, V> parent) {
        this.parent = parent;
    }
}
