import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyArrayListTest {

    // ADD (final)

    @Test
    void deveAdicionarElementoNoFinal() {
        MyArrayList<Integer> list = new MyArrayList<>();

        list.add(10);
        list.add(20);

        assertEquals(10, list.get(0));
        assertEquals(20, list.get(1));
    }

    @Test
    void deveAumentarCapacidadeAutomaticamente() {
        MyArrayList<Integer> list = new MyArrayList<>(2);

        list.add(1);
        list.add(2);
        list.add(3); // força increaseArray

        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));
    }

    // ADD (index)

    @Test
    void deveInserirNoInicio() {
        MyArrayList<Integer> list = new MyArrayList<>();

        list.add(10);
        list.add(20);

        list.add(0, 5);

        assertEquals(5, list.get(0));
        assertEquals(10, list.get(1));
        assertEquals(20, list.get(2));
    }

    @Test
    void deveInserirNoMeioEDeslocar() {
        MyArrayList<Integer> list = new MyArrayList<>();

        list.add(10);
        list.add(30);

        list.add(1, 20);

        assertEquals(10, list.get(0));
        assertEquals(20, list.get(1));
        assertEquals(30, list.get(2));
    }

    @Test
    void deveInserirNoFinalViaIndex() {
        MyArrayList<Integer> list = new MyArrayList<>();

        list.add(10);
        list.add(20);

        list.add(2, 30);

        assertEquals(30, list.get(2));
    }

    @Test
    void deveLancarErroAoAdicionarComIndiceInvalido() {
        MyArrayList<Integer> list = new MyArrayList<>();

        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.add(1, 10);
        });
    }

    // REMOVE (index)

    @Test
    void deveRemoverDoInicio() {
        MyArrayList<Integer> list = new MyArrayList<>();

        list.add(10);
        list.add(20);
        list.add(30);

        list.remove(0);

        assertEquals(20, list.get(0));
        assertEquals(30, list.get(1));
    }

    @Test
    void deveRemoverDoMeio() {
        MyArrayList<Integer> list = new MyArrayList<>();

        list.add(10);
        list.add(20);
        list.add(30);

        list.remove(1);

        assertEquals(10, list.get(0));
        assertEquals(30, list.get(1));
    }

    @Test
    void deveRemoverDoFinal() {
        MyArrayList<Integer> list = new MyArrayList<>();

        list.add(10);
        list.add(20);

        list.remove(1);

        assertEquals(10, list.get(0));
    }

    @Test
    void deveLancarErroAoRemoverIndiceInvalido() {
        MyArrayList<Integer> list = new MyArrayList<>();

        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.remove(0);
        });
    }

    // REMOVE (valor)

    @Test
    void deveRemoverPorValor() {
        MyArrayList<Integer> list = new MyArrayList<>();

        list.add(10);
        list.add(20);
        list.add(30);

        list.remove(Integer.valueOf(20));

        assertEquals(10, list.get(0));
        assertEquals(30, list.get(1));
    }

    @Test
    void deveNaoRemoverValorInexistente() {
        MyArrayList<Integer> list = new MyArrayList<>();

        list.add(10);

//        Integer valorInexistente = 99;
//        list.remove(valorInexistente);

        list.remove(Integer.valueOf(99));

        assertEquals(10, list.get(0));
    }

    // SET / GET

    @Test
    void deveAtualizarValorComSet() {
        MyArrayList<Integer> list = new MyArrayList<>();

        list.add(10);

        list.set(0, 99);

        assertEquals(99, list.get(0));
    }

    @Test
    void deveLancarErroNoSetIndiceInvalido() {
        MyArrayList<Integer> list = new MyArrayList<>();

        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.set(0, 10);
        });
    }

    @Test
    void deveLancarErroNoGetIndiceInvalido() {
        MyArrayList<Integer> list = new MyArrayList<>();

        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.get(0);
        });
    }

    // INDEXOF / CONTAINS

    @Test
    void deveRetornarIndiceCorreto() {
        MyArrayList<Integer> list = new MyArrayList<>();

        list.add(10);
        list.add(20);

        assertEquals(1, list.indexOf(20));
    }

    @Test
    void deveRetornarMenosUmQuandoNaoEncontrar() {
        MyArrayList<Integer> list = new MyArrayList<>();

        assertEquals(-1, list.indexOf(99));
    }

    @Test
    void deveEncontrarNull() {
        MyArrayList<String> list = new MyArrayList<>();

        list.add("A");
        list.add(null);

        assertEquals(1, list.indexOf(null));
    }

    @Test
    void containsDeveFuncionarCorretamente() {
        MyArrayList<Integer> list = new MyArrayList<>();

        list.add(10);

        assertTrue(list.contains(10));
        assertFalse(list.contains(99));
    }

    // TO ARRAY

    @Test
    void toArrayDeveRetornarArrayComTamanhoExato() {
        MyArrayList<Integer> list = new MyArrayList<>();

        list.add(10);
        list.add(20);

        Integer[] array = list.toArray();

        assertEquals(2, array.length);
        assertEquals(10, array[0]);
        assertEquals(20, array[1]);
    }

    @Test
    void toArrayDeveSerCopiaIndependente() {
        MyArrayList<Integer> list = new MyArrayList<>();

        list.add(10);

        Integer[] array = list.toArray();
        array[0] = 99;

        assertEquals(10, list.get(0));
    }
}