/* CSCI 275 Module 8 Task 1 coding assignment
 * 
 * Name: Russell M. Streff Jr.       UIN:  677045604       Date:  12/9/18
 * ----------------------------------------------------------------------------
 * I declare that all material in this assessment task is my own work
 * except where there is clear acknowledgment or reference to the work
 * of others. I further declare that I have complied with, and agree to
 * abide by, the UIS Academic Integrity Policy at the University website: 
 * 
 * 					http://www.uis.academicintegrity
 * 
 * 
 * 
=============================================================================== 
    Module 8 Task 1 Assignment
===============================================================================
    FIBONACCI AND PRIME NUMBER ITERATOR
===============================================================================

Fibonacci or Prime number iterator:

Design a menu driven program that performs the user’s choice of the following functions 
the program exits should also be a user’s choice.

Menu Item 1:
----------------
Fibonacci number iterator, here you are to define an iterator class named FibonacciIterator for iterating 
Fibonacci numbers.  The constructor takes an argument that specifies the limit of the maximum Fibonacci number.  
For example, prompt the user for size, use the size to call FibonacciIterator(“user input”) creates an 
iterator that iterates Fibonacci  numbers  less than or equal to “user input”.  Your program then uses 
this iterator to display all Fibonacci numbers less than or equal to “user input” in Descending order.


Menu Item 2:
----------------
Prime number iterator here you are to define an iterator class named PrimeIterator for iterating prime numbers.  
The constructor takes an argument that specifies the limit of the maximum prime number. For example, 
prompt the user for size, use the size to call PrimeIterator(“user input”) creates an iterator that 
iterates prime numbers less than or equal to “user input”. Your program then uses this iterator to display 
all prime numbers less than or equal to “user input” in Descending order.


Menu Item 3:
-----------------
Exit command, this should present a report of the operations requested since the program was invoked, the 
total time required for each, the program start and end time, I.E.:

2 Fibonacci commands yielding 713 individual outputs requiring 5.7 seconds.
1 Prime command yielding 27 individual outputs requiring 0.3 seconds. 
Program started at 21:33:00 and terminated at: 21:34:12.

 * */

// import java.util.Scanner for user input
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;



// declare FibonacciAndPrimeNumberIterator class
public class FibonacciAndPrimeNumberIterators {
	
	// declare static long variables to track time elapsed for total program, Fibonacci sequence
	// and Prime number sequence initializing to zero
	static long startProgTime = 0;
	static long endProgTime = 0;
	static long totalProgTime = 0;
	static long startFibonacciTime;
	static long endFibonacciTime;
	static long totalFibonacciTime;
	static long totalOverFibonacciTime;
	static int fibOutputCount = 0;
	static long startPrimeTime = 0;
	static long endPrimeTime = 0;
	static long totalPrimeTime = 0;
	static long totalOverallPrimeTime;
	static long primeOutputCount = 0;
	static int fibCount = 0;
	static int primeCount = 0;

	// declare main method
	public static void main(String[] args) {
		
		// start timer for elapsed program time
		startProgTime = System.currentTimeMillis();
		// prompt user input to choose function from menu
		System.out.println("\n\nPlease enter your choice from the following menu");
		System.out.println("------------------------------------------------");
		System.out.println("#1: Fibonacci iterator (enter '1')");
		System.out.println("#2: Prime number iterator (enter '2')");
		System.out.println("#3: Exit program (enter '3')");
		// declare Scanner variable input and take in user choice
		Scanner input = new Scanner(System.in);
		int choice = input.nextInt();
		 
		// switch statement determining user choice and invoking respective methods		
		switch(choice) {
		case 1:	System.out.println("Please enter the maximum size of the Fibonacci number: ");
		        int fibMax = 0;
		        fibMax = input.nextInt();
		        FibonacciIterator(fibMax);
		        main(args);	
		case 2: System.out.println("Please enter the maximum limit of the prime number:");
				int primeMax = 0;
				primeMax = input.nextInt();
				PrimeNumberIterator(primeMax);
				main(args);
				
		case 3: input.close(); System.out.println("\nComputation complete");
				System.out.println("---------------------");
				endProgTime = System.currentTimeMillis();
				totalProgTime = endProgTime - startProgTime;
				System.out.println(fibCount + " Fibonacci command(s) yielding " + fibOutputCount 
						+ " individual outputs requiring " + totalOverFibonacciTime + " second(s)");
				System.out.println(primeCount + " Prime number command(s) yielding " + primeOutputCount
						+ " individual outputs requiring " + totalOverallPrimeTime + " second(s)");
				DateFormat df = new SimpleDateFormat("HH':'mm':'ss");
				System.out.println("Program started at " + df.format(new Date(startProgTime)) + " and ended at " + df.format(new Date(endProgTime)));
				System.exit(1);
				break;
				
		default: System.out.println("\nERROR: INVALID ENTRY, TRY AGAIN"); main(args);
		}
		
		
	}
	// close main method
	
	// declare Fibonacci iterator method passing in an integer variable from user for maximum number
	// of Fibonacci sequence
	public static int FibonacciIterator(int fibMax){

		startFibonacciTime = System.currentTimeMillis();
		fibCount++;
		List<Integer> list;
		list = new ArrayList<>();
		int a = 0, b = 1;
		while (a <= fibMax) {

			list.add(a);
			int sum = a + b;
			a = b;
			b = sum;
		}
 
		System.out.println("\nFibonacci sequence in descending order up to " + fibMax + " is: ");
		for (int i = list.size()-1; i >=0; i--) {
			fibOutputCount++;
			System.out.print(list.get(i)+" ");		
		}
		endFibonacciTime = System.currentTimeMillis();
        totalFibonacciTime = endFibonacciTime - startFibonacciTime;
        totalOverFibonacciTime += totalFibonacciTime;
        
		return fibMax;
	}
	
	public static int PrimeNumberIterator(int maxPrime){
		
		startPrimeTime = System.currentTimeMillis();
		primeCount++;
		int[] array=new int[1000];
        int i,j=0;
        boolean isPrime;
        for (i = 1; i <= maxPrime; i++) {
            isPrime = CheckPrime(i);
            if (isPrime) {
                array[j++]=i;
            }
        }
        int n=j;
        System.out.println("Prime numbers in descending order from "+ maxPrime +" down to 2 are:");
        for (j=n-1;j>=0;j--) {
        	primeOutputCount++;
            System.out.print(array[j]+" ");
        }
        endPrimeTime = System.currentTimeMillis();
        totalPrimeTime = endPrimeTime - startPrimeTime;
        totalOverallPrimeTime += totalPrimeTime;
        return maxPrime;
    }
	// close PrimeNumberIterator method
	
    public static boolean CheckPrime(int numberToCheck) {
        int remainder;
        for (int i = 2; i <= numberToCheck / 2; i++) {
            remainder = numberToCheck % i;
            if (remainder == 0) {
                return false;
            }
        }
        if(numberToCheck==1)
            return false;
        return true;
	}
    // close CheckPrime method
}
// close FibonacciAndPrimeNumberIterators class
