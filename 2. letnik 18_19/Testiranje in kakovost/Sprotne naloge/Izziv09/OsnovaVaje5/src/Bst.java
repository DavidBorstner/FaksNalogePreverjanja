
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Bst<Tip extends Comparable> implements Seznam<Tip> {

    class ElementBST {

        public Tip value;
        public ElementBST left, right;

        public ElementBST(Tip e) {
            this(e, null, null);
        }

        public ElementBST(Tip e, ElementBST lt, ElementBST rt) {
            value = e;
            left = lt;
            right = rt;
        }
    }

    public List<Tip> vrni = new ArrayList<Tip>();
    ElementBST rootNode;
    private Tip minNodeValue;

    public Bst() {
        rootNode = null;
    }

    private boolean member(Tip e) {
        return member(e, rootNode);
    }

    private boolean member(Tip e, ElementBST node) {
        if (node == null) {
            return false;
        } else if (e.compareTo(node.value) == 0) {
            return true;
        } else if (e.compareTo(node.value) < 0) {
            return member(e, node.left);
        } else {
            return member(e, node.right);
        }
    }

    private void insert(Tip e) {
        rootNode = insertLeaf(e, rootNode);
    }

    private void delete(Tip e) {
        rootNode = delete(e, rootNode);
    }

    private ElementBST insertLeaf(Tip e, ElementBST node) {
        if (node == null) {
            node = new ElementBST(e);
        } else if (e.compareTo(node.value) < 0) {
            node.left = insertLeaf(e, node.left);
        } else if (e.compareTo(node.value) > 0) {
            node.right = insertLeaf(e, node.right);
        } else {
            throw new java.lang.IllegalArgumentException(); //element ze obstaja
        }
        return node;
    }

    private ElementBST delete(Tip e, ElementBST node) {
        if (node == null) {
            return node;
        }

        if (e.compareTo(node.value) > 0) {
            node.left = delete(e, node.left);
        } else if (e.compareTo(node.value) < 0) {
            node.right = delete(e, node.right);
        } else {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }

            node.value = min(node.right);
            node.right = delete(node.value, node.right);
        }
        vrni.remove(e);
        return node;
    }

    Tip min(ElementBST node) {
        Tip minv = node.value;
        while (node.left != null) {
            minv = node.left.value;
            node = node.left;
        }
        return minv;
    }

    private ElementBST deleteMin(ElementBST node) {
        ElementBST current = node;
        Tip minv = node.value;
        while (node.left != null) {
            minv = node.left.value;
            node = node.left;
        }
        node.left = delete(current.value, current.left);
        vrni.remove(current.left);
        return current;
    }

    private int getDepth(ElementBST node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(getDepth(node.left), getDepth(node.right));
    }

    private int countNodes(ElementBST node) {
        if (node == null) {
            return 0;
        }
        int i = 1 + countNodes(node.left) + countNodes(node.right);
        return i;
    }

    @Override
    public void add(Tip e) {
        insert(e);
        vrni.add(e);
    }

    @Override
    public Tip removeFirst() {
        if (this.isEmpty()) {
            throw new java.util.NoSuchElementException();
        }
        Tip el = rootNode.value;
        delete(rootNode.value);
        vrni.remove(0);
        return el;
    }

    @Override
    public Tip getFirst() {
        if (this.isEmpty()) {
            throw new java.util.NoSuchElementException();
        }
        return rootNode.value;
    }

    @Override
    public int size() {
        int i = countNodes(rootNode);
        return i;
    }

    @Override
    public int depth() {
        return getDepth(rootNode);
    }

    @Override
    public boolean isEmpty() {
        return (rootNode == null);
    }

    @Override
    public Tip remove(Tip e) {
        if (!this.exists(e)) {
            throw new java.util.NoSuchElementException();
        } else {
            delete(e);
        }
        return e;
    }

    public boolean removeMin(ElementBST node) {
        ElementBST current = deleteMin(node);
        return true;
    }

    @Override
    public boolean exists(Tip e) {
        return member(e);
    }

    public List<Tip> koncno = new ArrayList<>();

    @Override
    public List asList() {
        if (this.isEmpty()) {
            return this.koncno;
        }

        printInOrderRec(rootNode);

        return this.koncno;
    }

    private void printInOrderRec(ElementBST node) {
        if (node == null) {
            return;
        }

        printInOrderRec(node.left);
        if (!this.koncno.contains(node.value)) {
            this.koncno.add(node.value);
        }
        printInOrderRec(node.right);
    }

    @Override
    public void print() {
        print(rootNode, 0);
    }

    private void print(ElementBST node, int numTabs) {
        if (node == null) {
            return;
        }
        print(node.right, numTabs + 1);
        for (int i = 0; i < numTabs; i++) {
            System.out.print('\t');
        }
        System.out.println(node.value);
        print(node.left, numTabs + 1);
    }

    @Override
    public void save(OutputStream outputStream) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(outputStream);
        out.writeInt(this.size());
        save(rootNode, out);
    }

    private void save(ElementBST node, ObjectOutputStream out) throws
            IOException {
        if (node == null) {
            return;
        }
        save(node.left, out);
        out.writeObject(node.value);
        save(node.right, out);
    }

    @Override
    public void restore(InputStream inputStream) throws IOException,
            ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(inputStream);
        int count = in.readInt();
        rootNode = restore(in, count);
    }

    private ElementBST restore(ObjectInputStream in, int count) throws
            IOException, ClassNotFoundException {
        if (count == 0) {
            return null;
        }
        ElementBST nodeLeft = restore(in, count / 2);
        ElementBST node = new ElementBST((Tip) in.readObject());
        node.left = nodeLeft;
        node.right = restore(in, (count - 1) / 2);
        return node;
    }

}
