import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MergeSort extends StringSorter {

    private String[] arrayOrdenado;

    public String[] getArrayOrdenado() {
        return arrayOrdenado;
    }

    public MergeSort(){

    }


    public void sort(String[] datos) {
        datos = mergeSort(datos);
    }

    private String[] mergeSort(String[] datos){
        if(datos.length == 1){
            return datos;
        }

        String[] izquierda = new String[datos.length/2];
        String[] derecha = new String[datos.length-izquierda.length];
        System.arraycopy(datos,0,izquierda,0,izquierda.length);
        System.arraycopy(datos,izquierda.length,derecha,0,derecha.length);

        mergeSort(izquierda);
        mergeSort(derecha);

        merge(izquierda,derecha,datos);
        return datos;
    }

    private void merge(String[] izquierda, String[] derecha, String[] datos) {
        int posIzquierda = 0;
        int posDerecha = 0;

        int j = 0;

        while (posIzquierda < izquierda.length && posDerecha < derecha.length) {
            if (izquierda[posIzquierda].compareTo(derecha[posDerecha]) <= 0) {
                datos[j] = izquierda[posIzquierda];
                posIzquierda++;
            } else {
                datos[j] = derecha[posDerecha];
                posDerecha++;
            }
            j++;
        }
        // copy what's left
        System.arraycopy(izquierda, posIzquierda, datos, j, izquierda.length - posIzquierda);
        System.arraycopy(derecha, posDerecha, datos, j, derecha.length - posDerecha);
    }

    private List<String> sortList(List<String> datosLista) {
        if (datosLista.size() < 2){
            return datosLista;
        } else{

            //Calculamos el punto medio
            int medio = datosLista.size()/2;
            List<String> listIzq = new ArrayList<>(datosLista.subList(0,medio));
            List<String> listDer = new ArrayList<>(datosLista.subList(medio,datosLista.size()));
            List<String> listaResultado = new ArrayList<>();


            listIzq = sortList(listIzq);
            listDer = sortList(listDer);

            listaResultado.clear();

            //Merger
            while(listIzq.size() > 0 && listDer.size() > 0){
                if(OpMeter.compareTo(listIzq.get(0),listDer.get(0)) < 0){
                    listaResultado.add(listIzq.get(0));
                    listIzq.remove(0);
                } else {
                    listaResultado.add(listDer.get(0));
                    listDer.remove(0);
                }
            }

            listaResultado.addAll(listIzq);
            listaResultado.addAll(listDer);
            return listaResultado;
        }


    }



    public static void main(String args[]){
        MergeSort sorter = new MergeSort();
        String[] lista = {"Hola","Adios","Caca","llave","nada","//","sjsjs"};
        String[] listaOrdenada;
        sorter.sort(lista);
        listaOrdenada = sorter.getArrayOrdenado();
        for(String e : listaOrdenada){
            System.out.println(e);
        }
    }

}
