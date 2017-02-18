/**
 * Created by jcala on 18/02/2017.
 */
public class Main {

    public static void main(String[] args){
        String[] palabras = {"llave","pie","movil","flauta"};
        String[] simbolos = {"{","}","·",".",",","*","/","-","z"};

        StringSorter sorter = new MergeSort();
        sorter.sort(palabras);
        for(String s : simbolos){
            System.out.println(s);

        }
    }
}
