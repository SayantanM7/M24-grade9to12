package m24;

import java.util.ArrayList;

public class main7 {
	 public static void main(String[] args) {
		System.out.println("==========Lambdas=======");
	    ArrayList<Integer> numbers = new ArrayList<Integer>();
	    numbers.add(35);
	    numbers.add(48);
		//numbers.add(49);
	    numbers.add(18);
	    numbers.add(13);
	    numbers.forEach( (x) -> { System.out.println(x); } );
		numbers.forEach(n -> { if (n == 49) System.out.println("Found 49");
								 });
	  }
	}