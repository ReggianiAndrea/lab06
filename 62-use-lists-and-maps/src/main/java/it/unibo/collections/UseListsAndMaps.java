package it.unibo.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        
        for(int i=1000;i<2000;i++){
            arrayList.add(i);
        }
        System.out.println("primo ARRAY");
        System.out.println(arrayList);

        
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
        LinkedList<Integer> LinkedList= new LinkedList<Integer>();
        LinkedList.addAll(arrayList);

        System.out.println("Secondo ARRAY");
        System.out.println(LinkedList);



        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
        int temp1 = arrayList.get(0);
        System.out.println(temp1);
        int temp2 = arrayList.get(arrayList.size()-1);
        System.out.println(temp2);
        arrayList.set(0, temp2);
        arrayList.set(arrayList.size()-1, temp1);
        System.out.println("funzionato");
        


        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        System.out.println("PUNTO 4");
        for(final int value : arrayList){
            System.out.print(value+" ");
        }


        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        long start=System.nanoTime();
        ArrayList<Integer> arrayList2 = new ArrayList<Integer>();
        for(int i=0; i<100000;i++) {
            arrayList2.add(i);
            
        }
        long duration=System.nanoTime()-start;
        System.out.println("tempo per arrayList = "+ duration);

        //parte 2 di es 5
        long start2=System.nanoTime();
        LinkedList<Integer> linkedList2 = new LinkedList<Integer>();
        for(int i=0; i<100000;i++) {
            linkedList2.add(i);
            
        }
        long duration2=System.nanoTime()-start2;
        System.out.println("tempo per LinkedList = "+ duration2);

        

        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
        long start3=System.nanoTime();
        int middle=arrayList2.size()/2;
        for(int counter=0; counter<1000;counter++){
            arrayList2.get(middle);
        }
        long duration3=System.nanoTime()-start3;
        System.out.println(duration3);

        long start4=System.nanoTime();
        int middle2=linkedList2.size()/2;
        for(int counter=0; counter<1000;counter++){
            linkedList2.get(middle2);
        }
        long duration4=System.nanoTime()-start4;
        System.out.println(duration4);


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

        HashMap<String,Long> worldMap= new HashMap<>();
        worldMap.put("Africa", 1110635000L);
        worldMap.put("America", 972005000L);
        worldMap.put("Antartica", 0L);
        worldMap.put("Asia", 4298723000L);
        worldMap.put("Europe", 742452000L);
        worldMap.put("Oceania", 38304000L);
        /*
         * 8) Compute the population of the world
         */
        long population=0;
         for(String country:worldMap.keySet()){
            population+=worldMap.get(country);
         }
         System.out.println(population);
    }
}
