/**
 * Created by jcala on 18/02/2017.
 */
public class Main {

    public static void main(String[] args){
        String[] palabras = {"hola","55","55","55","flauta","aka","11"};
        String[] simbolos = {"{","}","·",".",",","*","/","-","z"};
        System.out.println(palabras[4].compareTo(palabras[3]));
        StringSorter sorter = new MergeSort();
        sorter.sort(palabras);
        for(String s : palabras){
            System.out.println(s);

        }
    }
}
