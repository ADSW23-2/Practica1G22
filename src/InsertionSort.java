/**
 * Created by jcala on 14/02/2017.
 */

public class InsertionSort extends StringSorter{


    private String tmp[];

    public String[] getArray(){
        return tmp;
    }

    @Override
    public void sort(String[] datos) {
        tmp = datos;
        for(int i = 0; i < tmp.length; i++){
            int j = i;
            int z = i;
            String v = tmp[i];
            while(0 < j && OpMeter.compareTo(v,tmp[j-1]) < 0){
                j--;
                System.arraycopy(tmp,j,tmp,j+1,z-j);
                tmp[j] = v;
            }
        }
    }

    public static void main(String[] args){
        InsertionSort sorter = new InsertionSort();
        String[] lista = {"Hola","Adios","Caca","llave","nada"};
        String[] listaOrdenada;
        sorter.sort(lista);
        listaOrdenada = sorter.getArray();
        for(String e: listaOrdenada){
            System.out.println(e);
        }
    }
}
