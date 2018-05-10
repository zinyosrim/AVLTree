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

    public V getValue() { return value; }

    public K getKey() {
        return key;
    }

    public int getHeight() { return height; }

    public AvlNode<K, V> getLeft() { return left; }

    public AvlNode<K, V> getRight() { return right; }

    public AvlNode<K, V> getParent() {
        return parent;
    }

    public void setLeft(AvlNode<K, V> left) {
        this.left = left;
    }

    public void setRight(AvlNode<K, V> right) {
        this.right = right;
    }

    public void setParent(AvlNode<K, V> parent) {
        this.parent = parent;
    }

    public void setValue(V value) {
        this.value = value;
    }

}
