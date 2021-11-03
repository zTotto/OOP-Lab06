package it.unibo.oop.lab.collections1;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Example class using {@link java.util.List} and {@link java.util.Map}.
 * 
 */
public final class UseCollection {

	private UseCollection() {
	}

	private static final int ELEMS = 100_000;
	private static final int READ = 1_000;
	private static final int TO_MS = 1_000_000;

	/**
	 * @param s unused
	 */
	public static void main(final String... s) {
		/*
		 * 1) Create a new ArrayList<Integer>, and populate it with the numbers from
		 * 1000 (included) to 2000 (excluded).
		 */
		/*
		 * 2) Create a new LinkedList<Integer> and, in a single line of code without
		 * using any looping construct (for, while), populate it with the same contents
		 * of the list of point 1.
		 */
		/*
		 * 3) Using "set" and "get" and "size" methods, swap the first and last element
		 * of the first list. You can not use any "magic number". (Suggestion: use a
		 * temporary variable)
		 */
		/*
		 * 4) Using a single for-each, print the contents of the arraylist.
		 */
		/*
		 * 5) Measure the performance of inserting new elements in the head of the
		 * collection: measure the time required to add 100.000 elements as first
		 * element of the collection for both ArrayList and LinkedList, using the
		 * previous lists. In order to measure times, use as example
		 * TestPerformance.java.
		 */
		/*
		 * 6) Measure the performance of reading 1000 times an element whose position is
		 * in the middle of the collection for both ArrayList and LinkedList, using the
		 * collections of point 5. In order to measure times, use as example
		 * TestPerformance.java.
		 */
		/*
		 * 7) Build a new Map that associates to each continent's name its population:
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
		/*
		 * 8) Compute the population of the world
		 */

		final List<Integer> num = new ArrayList<>();
		for (int i = 1000; i < 2000; i++) {
			num.add(i);
		}
		System.out.println("Lista 1: " + num);
		final List<Integer> num2 = new LinkedList<>(num);
		System.out.println("Lista 2: " + num2);

		int a = num.get(num.size() - 1);

		num.set(num.size() - 1, num.get(0));
		num.set(0, a);

		for (int i : num) {
			System.out.print(i + " ");
		}

		
		//LISTA 1 WRITE
		
		long time = System.nanoTime();
		for (int i = 1; i <= ELEMS; i++) {
            num.set(0, 1);
        }
		
		time = System.nanoTime() - time;
        System.out.println("\n\n\n\n\n\n\n\n\n\nInserting " + ELEMS
                + " int in a Set took " + time
                + "ns (" + time / TO_MS + "ms)");
        
        
        //LISTA 2 WRITE
        
        long time2 = System.nanoTime();
		for (int i = 1; i <= ELEMS; i++) {
            num2.set(0, 1);
        }
		
		time2 = System.nanoTime() - time2;
        System.out.println("\nInserting " + ELEMS
                + " int in a Set took " + time2
                + "ns (" + time2 / TO_MS + "ms)");
        
        
        //LISTA 1 READ
        
        long time3 = System.nanoTime();
		for (int i = 1; i <= READ; i++) {
            num.get(num.size()/2);
        }
		
		time3 = System.nanoTime() - time3;
        System.out.println("\nReading " + READ
                + " int in a Set took " + time3
                + "ns (" + time3 / TO_MS + "ms)");
        //LISTA 1 READ
        
        long time4 = System.nanoTime();
		for (int i = 1; i <= READ; i++) {
            num2.get(num2.size()/2);
        }
		
		time4 = System.nanoTime() - time4;
        System.out.println("\nReading " + READ
                + " int in a Set took " + time4
                + "ns (" + time4 / TO_MS + "ms)");
        
        
        final Map<String, Double> pop = new HashMap<>();
        
        pop.put("Africa", 1_110_635_000d);
        pop.put("Americas", 972_005_000d);
        pop.put("Antarctica", 0d);
        pop.put("Asia", 4_298_723_000d);
        pop.put("Europe", 742_452_000d);
        pop.put("Oceania", 38_304_000d);
        
        Double tPop = 0.0;
        for (Double i : pop.values()) {
        	tPop = tPop + i;
        }
        
        System.out.println("\nThe world population counts " + tPop + " people");
	}

}
