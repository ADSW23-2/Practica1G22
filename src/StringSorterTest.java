import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertArrayEquals;

public class StringSorterTest {

    private final int LONGABC = 26;

    private Random random = new Random();
    private String[] carga1 = new String[LONGABC];
    private String[] carga2 = new String[LONGABC];
    private String[] carga3 = new String[LONGABC];
    private String[] carga4 = new String[LONGABC];
    private String[] carga5 = new String[LONGABC];
    private String[] cargaConEnie = new String[LONGABC+1];
    private String[] cargaConNumeros = new String[LONGABC+10];
    private String[] cargaConSimbolos = new String[LONGABC+8]; //Para añadir esta prueba hay que meter los simbolos segun el codigo ASCII

    private String[] carga1d = new String[LONGABC];
    private String[] carga2d = new String[LONGABC];
    private String[] carga3d = new String[LONGABC];
    private String[] carga4d = new String[LONGABC];
    private String[] carga5d = new String[LONGABC];
    private String[] cargaConEnied = new String[LONGABC+1];
    private String[] cargaConNumerosd = new String[LONGABC+10];
    private String[] cargaConSimbolosd = new String[LONGABC+8];

    private StringSorter sorterInsertion = new InsertionSort();
    private MergeSort sorterMerge = new MergeSort();


    @Before
    public void setUp() throws Exception {
        carga1 = abecedario();
        carga2 = abecedario(2);
        carga3 = abecedario(3);
        carga4 = abecedario(4);
        carga5 = abecedario(5);



        System.arraycopy(carga1,0,cargaConEnie,0,carga1.length);
        cargaConEnie[cargaConEnie.length-1] = "ñ";



        System.arraycopy(carga1,0,cargaConNumeros,10,carga1.length);
        for(int i = 0; i < 10; i++){
            cargaConNumeros[i] = String.valueOf(i);
        }




        System.arraycopy(carga1,0,cargaConSimbolos,0,carga1.length);
        String[] simbolos = {"*",",","-",".","/","{","}","."};
        System.arraycopy(simbolos,0,cargaConSimbolos,carga1.length,simbolos.length);



    }

    @Test
    public void testMergeSort(){
        carga1d = desordenar(carga1);
        carga2d = desordenar(carga2);
        carga3d = desordenar(carga3);
        carga4d = desordenar(carga4);
        carga5d = desordenar(carga5);

        cargaConEnied = desordenar(cargaConEnie);


        cargaConNumerosd = desordenar(cargaConNumeros);

        cargaConSimbolosd = desordenar(cargaConSimbolos);



        //TODO: VER POR QUE COJONES NO SE PASA EL VALOR AL ARRAY
        sorterInsertion.sort(carga1d);
        sorterMerge.sort(carga2d);
        carga2d = sorterMerge.getArrayOrdenado();
        sorterMerge.sort(carga3d);
        carga3d = sorterMerge.getArrayOrdenado();
        sorterMerge.sort(carga4d);
        carga4d = sorterMerge.getArrayOrdenado();
        sorterMerge.sort(carga5d);
        carga5d = sorterMerge.getArrayOrdenado();
        sorterMerge.sort(cargaConEnied);
        cargaConEnied = sorterMerge.getArrayOrdenado();
        sorterMerge.sort(cargaConNumerosd);
        cargaConNumerosd = sorterMerge.getArrayOrdenado();
        //sorterMerge.sort(cargaConSimbolosd);
        //printer(cargaConSimbolos);
        //printer(cargaConSimbolosd);


        assertArrayEquals(carga1,carga1d);
        assertArrayEquals(carga2,carga2d);
        assertArrayEquals(carga3,carga3d);
        assertArrayEquals(carga4,carga4d);
        assertArrayEquals(carga5,carga5d);
        assertArrayEquals(cargaConEnie,cargaConEnied);
        assertArrayEquals(cargaConNumeros,cargaConNumerosd);
        //assertArrayEquals(cargaConSimbolos,cargaConSimbolosd);


    }

    @Test
    public void testInsertionSort(){
        carga1d = desordenar(carga1);
        carga2d = desordenar(carga2);
        carga3d = desordenar(carga3);
        carga4d = desordenar(carga4);
        carga5d = desordenar(carga5);

        cargaConEnied = desordenar(cargaConEnie);


        cargaConNumerosd = desordenar(cargaConNumeros);

        cargaConSimbolosd = desordenar(cargaConSimbolos);

        sorterInsertion.sort(carga1d);
        printer(carga1d);
        printer(carga1);
        sorterInsertion.sort(carga2d);
        sorterInsertion.sort(carga3d);
        sorterInsertion.sort(carga4d);
        sorterInsertion.sort(carga5d);
        sorterInsertion.sort(cargaConEnied);
        sorterInsertion.sort(cargaConNumerosd);
        sorterInsertion.sort(cargaConSimbolosd);
        printer(cargaConSimbolos);
        printer(cargaConSimbolosd);

        assertArrayEquals(carga1,carga1d);
        assertArrayEquals(carga2,carga2d);
        assertArrayEquals(carga3,carga3d);
        assertArrayEquals(carga4,carga4d);
        assertArrayEquals(carga5,carga5d);
        assertArrayEquals(cargaConEnie,cargaConEnied);
        assertArrayEquals(cargaConNumeros,cargaConNumerosd);
        //assertArrayEquals(cargaConSimbolos,cargaConSimbolosd);
    }

    private String[] abecedario(){
        String[] lista = new String[LONGABC];
        for(int i = 0; i < lista.length; i++){
            lista[i] = String.valueOf((char)(97+i));
        }
        return  lista;
    }

    private String[] abecedario(int n){
        String[] lista = abecedario();
        for (int j = 0; j <= n; j++) {
            for (int i = 0; i < lista.length; i++) {
                //Aniade una letra aleatoria al abecedario basico
                lista[i].concat(String.valueOf((char)(random.nextInt(LONGABC)+97)));
            }
        }
        return lista;
    }

    private void printer(String[] toPrint){
        for(String s : toPrint){
            System.out.print(s);
        }
        System.out.println(" ");
    }

    private String[] desordenar(String[] listaOrdenada){
        String[] lista = new String[listaOrdenada.length];
        System.arraycopy(listaOrdenada,0,lista,0,listaOrdenada.length);
        for (int i = lista.length - 1; i > 0; i--)
        {
            int index = random.nextInt(i + 1);
            // Simple swap
            String a = lista[index];
            lista[index] = lista[i];
            lista[i] = a;
        }
        return lista;
    }
}