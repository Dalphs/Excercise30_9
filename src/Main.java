import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static Set<Integer> sets = new HashSet<>();

    public static void main(String[] args) {
        Runnable add = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    sets.add(i);
                }
            }
        };

        Runnable iterate = new Runnable() {
            @Override
            public void run() {
                Iterator iterator = sets.iterator();
                while (iterator.hasNext()){
                    System.out.println(iterator.next());
                }
            }
        };

        ExecutorService pool = Executors.newFixedThreadPool(2);
        pool.execute(add);
        pool.execute(iterate);


    }
}
