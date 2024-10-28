package it.unibo.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {

    private UseListsAndMaps() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */

        var array = new ArrayList<Integer>();

        for (int i = 1000; i < 2000; i++) {
            array.add(i);
        }

        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
        

        var list = new LinkedList<Integer>(array);

        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
        
        var numberToSwap = array.get(0);
        array.set(0, array.get(array.size() - 1));
        array.set(array.size() - 1, numberToSwap);

        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */

        /* for (Integer integer : list) {
            System.out.print(integer + " ");
        }
        System.out.println(); */

        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */

        //ArrayList -->
        final int ELEMS = 100_000;

        long time = System.nanoTime();
        /*
         * Run the benchmark
         */
        for (int i = 1; i <= ELEMS; i++) {
            array.add(i);
        }
        /*
         * Compute the time and print result
         */
        time = System.nanoTime() - time;
        var millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(// NOPMD
            "Adding "
                + ELEMS
                + " ints to the ArrayList took "
                + time
                + "ns ("
                + millis
                + "ms)"
        );

        //LinkedList -->

        time = System.nanoTime();
        /*
         * Run the benchmark
         */
        for (int i = 1; i <= ELEMS; i++) {
            array.add(i);
        }
        /*
         * Compute the time and print result
         */
        time = System.nanoTime() - time;
        millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(// NOPMD
            "Adding "
                + ELEMS
                + " ints to the LinkedList took "
                + time
                + "ns ("
                + millis
                + "ms)"
        );

        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */

        //ArrayList-->
        final int ELEMS_TO_READ = 1000;

         time = System.nanoTime();
         /*
          * Run the benchmark
          */
         int pos = array.size() / 2;
         for (int i = 1; i <= ELEMS_TO_READ; i++) {
            array.get(pos / 2);
         }
         /*
          * Compute the time and print result
          */
         time = System.nanoTime() - time;
         millis = TimeUnit.NANOSECONDS.toMillis(time);
         System.out.println(// NOPMD
             "Reading "
                 + ELEMS
                 + " from the ArrayList took "
                 + time
                 + "ns ("
                 + millis
                 + "ms)"
         );

        //LinkedList -->
         time = System.nanoTime();
         /*
          * Run the benchmark
          */
         pos = list.size() / 2;
         for (int i = 1; i <= ELEMS_TO_READ; i++) {
            list.get(pos / 2);
         }
         /*
          * Compute the time and print result
          */
         time = System.nanoTime() - time;
         millis = TimeUnit.NANOSECONDS.toMillis(time);
         System.out.println(// NOPMD
             "Reading "
                 + ELEMS
                 + " from the LinkedList took "
                 + time
                 + "ns ("
                 + millis
                 + "ms)"
         );

        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000
         */

         var map = new HashMap<String, Integer>();

        map.put("Africa", 1_110_635_000);
        map.put("Americas",  972_005_000); 
        map.put("Antarctica", 0);
        map.put("Asia",  972_005_000); 
        
        /*
         * 8) Compute the population of the world
         */

         var pop_collection = map.values();

         long sum = 0;
         for (Integer integer : pop_collection) {
             sum = sum + integer;
         }
 
         System.out.println(sum);

    }
}
