/**
 * Clases que ordenan arrays de String.
 */
public abstract class StringSorter {

    public abstract void sort(String[] datos);
    /**
     * Intercambio.
     * Lo que hay en la posicion i pasa a la posicion j.
     * Lo que hay en la posicion j pasa a la posicion i.
     */
    void swap(String[] datos, int i, int j) {
        String datos1 = datos[i];
        datos[i] = datos[j];
        datos[j] = datos1;
    }
    /**
     * Predicado.
     * @param datos Strings.
     * @return TRUE si los datos estan ordenados.
     */
    boolean isSorted(String[] datos) {
        return isSorted(datos,0,datos.length);
    }
    /**
     * Predicado.
     * @param datos Strings.
     * @return TRUE si los datos estan ordenados entre [a, z).
     */
    boolean isSorted(String[] datos, int a, int z){
        for(int i = a; i < z-1;i++){
            if(datos[i].compareTo(datos[i+1]) > 0){
                return false;
            }
        }
        return true;
    }
}
