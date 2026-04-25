public class MyTree<T> {
    Node<T> root;
    private int altura;

    public MyTree() {
        this.root = null;
        this.altura = 0;
    }

    // Methods
    public void add(T valor) {
        Node<T> novoNodo = new Node<>(valor);
        if (root == null) {
            root = novoNodo;
        }
    }
    public void remove(T valor) {
        if (root == null) {
            return;
        }
    }

    // Support Methods
    private void rotateLeft(Node node) {}
    private void rotateRight(Node node) {}
    private void balance() {}

    private static class Node<T> {
        T valor;
        Node<T> esquerda;
        Node<T> direita;

        public Node(T valor) {
            this.valor = valor;
        }
    }
}
