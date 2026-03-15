public class Main {
    final int GLOBAL_CAPACITY = 1;

    public static void main(String[] args) {

        MyArrayList<Integer> list1 = new MyArrayList<>(GLOBAL_CAPACITY);
        MyArrayList<Integer> list2 = new MyArrayList<>();

        list1.add(10);

//        for (int i = 0; i < 2; i++) {
//            System.out.println(list2.data[i]);
//        }
        list1.add(2);

        System.out.println(list1.capacity);
        System.out.println(list2.capacity);
        System.out.println(list1.size);
        System.out.println(list2.size);
        System.out.println(list1.get(0));

    }
}