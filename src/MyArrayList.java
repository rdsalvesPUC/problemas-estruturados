public class MyArrayList<T> {
    private T[] data;
    private int capacity;
    private int size;

    // Constructors
    public MyArrayList() {
        this(10);
    }
    public MyArrayList(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("A capacidade deve ser maior que 0");
        }

        this.data = (T[]) new Object[capacity];
        this.capacity = capacity;
        this.size = 0;
    }

    // Methods
    public void add(T valor){
        if (isArrayFull()) {
            increaseArray();
        }

        data[size] = valor;
        size++;
    }
    public void add(int index, T valor){
        if (!isIndexValidForAdd(index)) {
            throw new IndexOutOfBoundsException("Índice inválido");
        }

        if (isArrayFull()) {
            increaseArray();
        }

        for (int i = this.size; i >= (index + 1) ; i--) {
            data[i] = data[i-1];
        }

        data[index] = valor;
        size++;
    }
    public void remove(T valor){
        int index = indexOf(valor);

        if (index == -1) {
            throw new IndexOutOfBoundsException("Valor inexistente no array");
        }

        remove(index);
    }
    public void remove(int index){
        if (!isIndexValid(index)) {
            throw new IndexOutOfBoundsException("Índice inválido");
        }

        for (int i = index; i < (this.size - 1) ; i++) {
            data[i] = data[i + 1];
        }

        data[size - 1] = null;
        size--;
    }
    public void set(int index, T valor){
        if (!isIndexValid(index)) {
            System.out.println("Índice inválido");
        }

        data[index] = valor;
    }
    public T get(int index){
        if (!isIndexValid(index)) {
            throw new IndexOutOfBoundsException("Índice inexistente");
        }

        return data[index];
    }
    public boolean contains(T valor){
        return indexOf(valor) != -1;
    }
    public int indexOf(T valor) {
        for (int i = 0; i < this.size; i++) {
            if (data[i] == null && valor == null) {
                return i;
            } else if (data[i] != null && data[i].equals(valor)) {
                return i;
            }
        }
        return -1;
    }
    public T[] toArray(){
        int customCapacity = this.size;
        T[] array = (T[]) new Object[customCapacity];

        for (int i = 0; i < customCapacity; i++) {
            array[i] = data[i];
        }

        return array;
    }

    // Support Methods
    public boolean isArrayFull(){
        return (size == capacity);
    }
    public boolean isIndexValidForAdd(int index) {
        return (index >= 0 && index <= this.size);
    }
    public boolean isIndexValid(int index) {
        return (index >= 0 && index < this.size);
    }
    public void increaseArray() {
        int newCapacity = capacity + (capacity/2);

        if (newCapacity <= this.capacity) {
            newCapacity = capacity * 2;
        }

        T[] newArray = (T[]) new Object[newCapacity];

        for (int i = 0; i < this.size; i++) {
            newArray[i] = data[i];
        }

        this.data = newArray;
        this.capacity = newCapacity;
    }
}
