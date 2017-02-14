

import java.util.Random;

/**
 * Created by jcala on 14/02/2017.
 */
public class PruebaCalata {

    private static Random random = new Random();

    public static void main(String[] args){
        StringSorter sorter = new InsertionSort();

        int[] nn = { 100,200,500,1000,2000,5000,10000};

        for(int n : nn){
            for(int i = 0;i < 3; i++){
                long t  = sort(sorter, n);
                System.out.printf("%s %d%n",n,t);
            }
        }
    }

    private static long sort(StringSorter sorter, int n){
        long t = 0;
        for(int j = 0; j < 100;j++){
            String data[] = load(n);

            long t0 = OpMeter.reset();
            sorter.sort(data);
            long t2 = OpMeter.getOps();
            t += t2 - t0;
        }
        return t;
    }

    private static String[] load(int n){
        String[] data = new String[n];
        for(int i = 0; i<n; i++){
            int k = random.nextInt(4*n);
            data[i] = String.format("%x",k);
        }
        return data;
    }

}
