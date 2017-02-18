


public class InsertionSortTest {

    public void ordenar(String[] lista){
        int k = 0;
        while (k < lista.length) {
            String actual = lista[k];
            int j = k-1;
            while(j >= 0 && actual.compareTo(lista[j]) < 0){
                    swap(lista,j,j+1);
                    j--;
            }
            k++;
        }
    }

    void swap(String[] datos, int i, int j) {
        String datos1 = datos[i];
        datos[i] = datos[j];
        datos[j] = datos1;
    }

    public static void main(String args[]){
        String[] hola = {"zebra","adios muy buenas","adios","hola","boli","teclado","25","#brak"};
        InsertionSortTest test = new InsertionSortTest();
        test.ordenar(hola);
        for(String s : hola){
            System.out.println(s);
        }
    }



}