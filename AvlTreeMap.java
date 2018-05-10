import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * Generic AVL Tree implementation
 *
 * @param <K> Class for key
 * @param <V> Class for value
 *
 */
public class AvlTreeMap<K, V> implements SortedMap<K, V> {
    private Comparator<K> comparator;
    private AvlNode<K,V> root;

    public AvlTreeMap(Comparator<K> comparator){
        this.root = new AvlNode<>(null, null);
        this.root.setLeft(null);
        this.root.setRight(null);
        this.root.setParent(null);
        this.comparator = comparator;
    }

    /*public static <K extends Comparable<K>, V> AvlTreeMap<K, V> create() {
        return this(K::compareTo);
    }*/

    public AvlNode<K, V> getRoot() {
        return root;
    }

    /**
     * Checks if the map is empty.
     *
     * @return {@code true} if the map is empty, {@code false} otherwise.
     */
    @Override
    public boolean isEmpty() {
        return this.root.getKey() == null;
    }

    /**
     * Clears the map, removing all entries.
     *
     */
    @Override
    public void clear() {
        this.root = new AvlNode<>(null, null);
        this.root.setLeft(null);
        this.root.setRight(null);
        this.root.setParent(null);
    }

    /**
     * Checks if the map contains an entry for the given key.
     *
     * @param key
     *            the key to search for.
     * @return {@code true} if the map contains the key, {@code false}
     *         otherwise.
     */
    @Override
    public boolean containsKey(K key) {
        if ((this.find(key, this.root) == null)) {
            return false;
        } else return true;
    }

    /**
     * Gets the value mapped to the given key.
     *
     * @param key
     *            the key to loop up.
     * @return the value mapped to the given key, or {@code null} if no entry
     *         with the given key exists.
     */
    @Override
    public V get(K key) {
        AvlNode<K,V> nodeToFind = find(key, this.root);

        if (nodeToFind == null) {
            return null;

        } else return nodeToFind.getValue();
    }

    @Override
    public V put(K key, V value) {

        AvlNode<K, V> newNode = new AvlNode<>(key, value) ;

        // Tree is empty -> Set new node as root
        if ( this.isEmpty() ){
            this.root = newNode;
            return null;
        }

        // Tree is not empty
        AvlNode<K, V> currentNode = this.root;
        boolean notYetInsertedIntoTree = true;
        while (notYetInsertedIntoTree){

            // New node goes into the right branch
            if ( comparator.compare(newNode.getKey(), currentNode.getKey()) < 0) {

                if ( currentNode.getLeft() == null ){
                    currentNode.setLeft(newNode);
                    newNode.setParent(currentNode);

                } else currentNode = currentNode.getLeft();

            // New node goes into the right branch
            } else if ( comparator.compare(newNode.getKey(), currentNode.getKey() ) > 0){

                if ( currentNode.getRight() == null ) {
                    currentNode.setRight(newNode);
                    newNode.setParent(currentNode);
                } currentNode = currentNode.getRight();

            // Key exists in the tree. Set the new value
            } else {
                V oldValue = currentNode.getValue();
                currentNode.setValue(value);
                return oldValue;
            }
        }
        return null;
    }


    @Override
    public V remove(K key) {
        return null;
    }

    /**
     * Return an iterator with the values of the tree using inorder traversal.
     * @return iterator
     */
    @Override
    public Iterator<V> iterator() {
        return new Iterator<V>() {

            private AvlNode<K, V> next = min(root);

            // Helper method returning the node with min key in a subtree with a given subtree root
            private AvlNode<K, V> min(AvlNode<K, V> subTreeRoot) {

                if (subTreeRoot == null){
                    return null;
                }

                // Return the most left leaf node
                while ( subTreeRoot.getLeft() != null){
                    subTreeRoot = subTreeRoot.getLeft();
                }
                return subTreeRoot;
            }

            // Iterable interface implementation
            public boolean hasNext() {
                return (next != null);
            }

            // Iterable interface implementation
            public V next() {

                if (this.hasNext()) {
                    V tempVal = next.getValue();

                    if (next.getRight() == null) {

                        while ((next.getParent() != null) &&
                                (next == next.getParent().getRight() )) {
                            next = next.getParent();
                        }
                        next = next.getParent();

                    } else {
                        next = min(next.getRight());
                    }
                    return tempVal;
                }
                throw new NoSuchElementException();
            }
        };
    }

    /**
     * Find a node with a specific key in the tree
     *
     * @param key of node to find
     * @param node value of node
     * @return node if a node with the given key is found, otherwise null
     *
     */
    public AvlNode<K,V> find(K key, AvlNode<K, V> node) {
        if (this.isEmpty()) return null;

        AvlNode<K, V> currentNode = node;
        AvlNode<K, V> tempNode = new AvlNode<>(key, null);

        int myComparator = comparator.compare(tempNode.getKey(), currentNode.getKey());

        if (myComparator == 0)
            return currentNode;

        else if ( myComparator < 0 &&
                  (currentNode.getLeft() != null) )
            return this.find(key, currentNode.getLeft());

        else if ( myComparator > 0  &&
                  (currentNode.getRight() != null) )
            return this.find(key, currentNode.getRight());

        else return null;
    }

    /**
     * Return a string representation of the (sub)tree in pre-order
     *
     * @param node the top node of a (sub)tree
     * @return String representing a tree with root=node in preorder.
     *         e.g. ([1] b=1 () ([0] c=5 () ()))
     */
    private String preOrder( AvlNode<K, V> node ) {

        StringBuilder preOrderString = new StringBuilder();
        preOrderString.append("(");
        if (!this.isEmpty()) {
            AvlNode<K, V> currentNode = node;

            // build node part
            if ( currentNode.getKey() != null ) {
                preOrderString.append("[");
                preOrderString.append(this.balance(currentNode));
                preOrderString.append("] ");
                preOrderString.append(currentNode.getKey().toString());
                preOrderString.append("=");
                //preOrderString.append(currentNode.getKey().toString());
                preOrderString.append(currentNode.getValue().toString());
                preOrderString.append(" ");
            }

            // build left child part
            if ( currentNode.getLeft() != null )
                preOrderString.append(preOrder(currentNode.getLeft()));
            else preOrderString.append("() ");

            // build right child part
            if ( currentNode.getRight() != null )
                preOrderString.append(preOrder(currentNode.getRight()));
            else preOrderString.append("()");

        }
        preOrderString.append(")");
        return preOrderString.toString();
    }

    /**
     * Return the balance of a given node as the difference between it's
     * left subtree height and right subtree height
     * @param node
     * @return int
     */
    public int balance(AvlNode<K,V> node ) {
        return this.height(node.getLeft()) - this.height(node.getRight());
    }

    /**
     * Return heigth of tree
     * @param node
     * @return int max number of edges between root and leaves
     */
    public int height(AvlNode<K,V> node ) {

        // Empty tree case
        if (node == null) {
            return 0;
        }

        // Tree consists just of the root
        if ((node.getLeft() == null) && (node.getRight() == null)) {
            return 1;
        }

        // Left subtree is empty, but right not
        else if ((node.getLeft() == null) && (node.getRight() != null)) {
            return 1 + this.height(node.getRight());
        }

        // Right subtree is empty, but left not
        else if ((node.getRight() == null) && (node.getLeft() != null)) {
            return 1 + this.height(node.getLeft());
        }

        // Both children not empty
        else {
            return 1 + Math.max(this.height(node.getLeft()), this.height(node.getRight()));
        }
    }

    @Override
    public String toString() {
        return preOrder(this.root) + "\n";
    }
}
