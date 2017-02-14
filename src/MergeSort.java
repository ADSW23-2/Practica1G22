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
        List<String> datosLista = new ArrayList<>();
        Collections.addAll(datosLista, datos);
        List<String> listaOrdenada  = sortList(datosLista);
        arrayOrdenado = listaOrdenada.toArray(new String[listaOrdenada.size()]);
    }

    private List<String> sortList(List<String> datosLista) {
        if (datosLista.size() < 2){
            return datosLista;
        } else{

            //Calculamos el punto medio
            int medio = datosLista.size()/2;
            List<String> listIzq = new ArrayList<String>(datosLista.subList(0,medio));
            List<String> listDer = new ArrayList<String>(datosLista.subList(medio,datosLista.size()));
            List<String> listaResultado = new ArrayList<String>(datosLista.subList(medio,datosLista.size()));


            listIzq = sortList(listIzq);
            listDer = sortList(listDer);

            listaResultado.clear();
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
        String[] lista = {"Hola","Adios","Caca","llave","nada"};
        String[] listaOrdenada;
        sorter.sort(lista);
        listaOrdenada = sorter.getArrayOrdenado();
        for(String e : listaOrdenada){
            System.out.println(e);
        }
    }

}
