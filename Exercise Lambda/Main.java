import java.util.ArrayList;
import java.util.function.Function;

public class Main {

    private static List<AlphaNumeric> items = new List<>();
    private static AlphaNumeric[] array = new AlphaNumeric[20];

    public static void main(String[] args) {
    
    	// Populate the data structures for testing
    	fillStructures();

        // Practice creating and applying functions
        functionPractice();

        // Query the List with Functions
        // TODO -- Fill in the query method in List.
        queryWithFunctions();
    }

    //______________________________________________________________________
    //______________________________________________________________________
    public static void functionPractice() {
    
    	// Define each of these functions to extract either the alpha component or the numeric component. Your choice for Object.

        Function<AlphaNumeric,String> fnS;
        Function<AlphaNumeric,Integer> fnI;
        Function<AlphaNumeric,Object> fnO;
        
        // Pass your functions to these tests to see if they are working.
        //testAlpha(...);
        //testNumer(...);
        //testObject(...);
    }

    public static void testAlpha(Function<AlphaNumeric,String> fn) {
        // Print the results of applying the function to each element in array.
        System.out.println("\n-- Function testAlpha");
    }

    public static void testNumber(Function<AlphaNumeric,Integer> fn) {
        // Print the results of applying the function to each element in array.
        System.out.println("\n-- Function testNumber");
    }
    
    public static void testObject(Function<AlphaNumeric,Object> fn) {
        // Print the results of applying the function to each element in array.
        System.out.println("\n-- Function testObject");
    }

    //______________________________________________________________________
    //______________________________________________________________________
    public static void queryWithFunctions() {

        // Create a Function that returns a Boolean for matching the letter x
        
        // query the List items to find all "x" AlphaNumerics, save to ArrayList
        
        // print found elements
        System.out.println("\n-- Results of query for x");  

        
        // Create a Function that returns a Boolean for matching all numbers>=2
        
        // query the List items to find all that are >= 2, save to ArrayList
        
        // print found elements
        System.out.println("\n-- Results of query for >=2");  

    }
    
    //________________________________________________________________________
    public static void fillStructures() {
            // Fill a List and an array to practice with
        for (int i=0; i<4; i++) {
        	AlphaNumeric an = new AlphaNumeric("a",i);
        	items.add(an);	
        	array[i] = an;
        }
        for (int i=0; i<4; i++) {
        	AlphaNumeric an = new AlphaNumeric("g",i);
        	items.add(an);	
        	array[i+4] = an;
        }
        for (int i=0; i<4; i++) {
        	AlphaNumeric an = new AlphaNumeric("m",i);
        	items.add(an);	
        	array[i+8] = an;
        }
        for (int i=0; i<4; i++) {
        	AlphaNumeric an = new AlphaNumeric("s",i);
        	items.add(an);	
        	array[i+12] = an;	
        }
        for (int i=0; i<4; i++) {
        	AlphaNumeric an = new AlphaNumeric("x",i);
        	items.add(an);	
        	array[i+16] = an;
        }
        System.out.println("\nThe List");
		System.out.println(items);
		
		System.out.println("\nThe array");
		for (AlphaNumeric an : array) {
			System.out.print(an);
		}
		System.out.println();
	}
}