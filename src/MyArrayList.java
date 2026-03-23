public class MyArrayList<T> {
    public T[] data;
    public int capacity;
    public int size;

    // Constructors
    public MyArrayList() {
        this(10);
    }

    public MyArrayList(int capacity) {
        this.data = (T[]) new Object[capacity];
        this.capacity = capacity;
        this.size = 0;
    }

    // Methods
    public void add(T valor){
        if (isArrayFull()) {
            System.out.println("Array cheio");
            return;
        }

        data[size] = valor;
        size++;
    }
    public void add(int index, T valor){
        if (isIndexValidForAdd(index)) {
            if (isArrayFull()) {
                increaseArray();
            }

            for (int i = this.size; i >= (index + 1) ; i--) {
                data[i] = data[i-1];
            }

            data[index] = valor;
            size++;
        } else {
            System.out.println("Índice inválido");
        }
    }
    public void remove(T valor){
        int index = indexOf(valor);

        if (index == -1) {
            System.out.println("Valor inexistente no array");
        }

        data[index] = null;
        size--;
    }
    public void remove(int index){

    }
    public void set(int index, T valor){
        data[index] = valor;
        size++;
    }
    public T get(int index){
        return data[index];
    }
    public void contains(T valor){

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
    public void toArray(){

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

        T[] newArray = (T[]) new Object[newCapacity];

        for (int i = 0; i < this.size; i++) {
            newArray[i] = data[i];
        }

        this.data = newArray;
        this.capacity = newCapacity;
    }
}
