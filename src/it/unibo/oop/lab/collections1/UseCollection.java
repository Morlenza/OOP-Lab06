package it.unibo.oop.lab.collections1;

import java.util.*;


/**
 * Example class using {@link java.util.List} and {@link java.util.Map}.
 * 
 */
public final class UseCollection {
    
    private static final int START_NUMBER = 1000;
	private static final int FINAL_NUMBER = 2000;
	private static final int ELEMS = 100_000;
	private static final int TO_MS = 1_000_000;
	private static final int NUM_OF_READ = 1_000_000;
	
	private static final long AFRICA_POPULATION = 1_110_635_000L;
    private static final long AMERICAS_POPULATION = 972_005_000L;
    private static final long ANTARCTICA_POPULATION = 0L;
    private static final long ASIA_POPULATION = 4_298_723_000L;
    private static final long EUROPE_POPULATION = 742_452_000L;
    private static final long OCEANIA_POPULATION = 38_304_000L;
	
	 private UseCollection() {
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
    	
    	final List<Integer> aList = new ArrayList<>();
    	for(int i = START_NUMBER ; i < FINAL_NUMBER ; i++) {
    		aList.add(i);
    	}
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
    	
    	final List<Integer> linList = new LinkedList<>(aList);
    	
    	
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
    	
    	final int temp = aList.get(0);
    	aList.set(0, aList.get(aList.size() - 1));
    	aList.set(aList.size() - 1, temp);
    	
        /*
         *
         * 4) Using a single for-each, print the contents of the arraylist.
         */
    	
    	for(int i : aList) {
    		System.out.println(i);
    	}
    	
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
    	
    	aList.clear();
    	long time = System.nanoTime();
    	for (int i = 1; i <= ELEMS; i++) {
            aList.add(i);
        }
    	time = System.nanoTime() - time;
    	
    	linList.clear();
    	long time2 = System.nanoTime();
    	for (int i = 1; i <= ELEMS; i++) {
            linList.add(i);
        }
    	time2 = System.nanoTime() - time2;
    	
    	System.out.println("Inserting " + ELEMS + " int in a ArrayList took " + time
                + "ns (" + time / TO_MS + "ms)");
    	System.out.println("Inserting " + ELEMS + " int in a LinkedList took " + time2
                + "ns (" + time2 / TO_MS + "ms)");
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
    	
    	long time3 = System.nanoTime();
    	for (int i = 1; i <= NUM_OF_READ; i++) {
            aList.get(aList.size() / 2 );
        }
    	time3 = System.nanoTime() - time3;
    	
    	long time4 = System.nanoTime();
    	for (int i = 1; i <= NUM_OF_READ; i++) {
            linList.get(linList.size() / 2 );
        }
    	time4 = System.nanoTime() - time4;
    	
    	System.out.println("Reading " + NUM_OF_READ + "times an element in the middle position of an ArrayList took " + time3
                + "ns (" + time3 / TO_MS + "ms)");
    	System.out.println("Reading " + NUM_OF_READ + "times an element in the middle position of an ArrayList took " + time4
                + "ns (" + time4 / TO_MS + "ms)");
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
    	
    	final Map<String,Long> popuMap = new HashMap<>();
    	popuMap.put("Africa", AFRICA_POPULATION);
    	popuMap.put("Americas", AMERICAS_POPULATION);
    	popuMap.put("Antarctica", ANTARCTICA_POPULATION);
    	popuMap.put("Asia", ASIA_POPULATION);
    	popuMap.put("Europe", EUROPE_POPULATION);
    	popuMap.put("Oceania", OCEANIA_POPULATION);
    	
        /*
         * 8) Compute the population of the world
         */
    	long total = 0;
    	for (final long i : popuMap.values()) {
    		total += i;
    	}
    	
    	System.out.println("The population of the world is : " + total);
    }
}
