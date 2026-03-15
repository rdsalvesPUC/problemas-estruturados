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
        data[index] = valor;
        size++;
    };
    public void remove(int index){

    };
    public void remove(T o){

    };
    public void set(int index, T e){

    };
    public T get(int index){
        return data[index];
    };
    public void contains(T o){

    };
    public void indexOf(T o){

    };
    public void toArray(){

    };

    // Support Methods
    public boolean isArrayFull(){
        return (size == capacity);
    }
}
