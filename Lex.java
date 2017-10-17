/******
 * Name: VY PHAM
 * CruzID: vyapham
 * Assignment Name: pa1
 * Student ID #: 1593394
******/

import java.io.*;
import java.util.Scanner;
//import java.util.Vector;

public class Lex {
    public static void main(String[] args) throws IOException {
	Scanner in = null;
        PrintWriter out = null;
        String line = null;
        int n, lineNumber = 0;

	if (args.length < 2) {
       	    System.err.println("Usage: FileIO infile outfile");
	    System.exit(1);
	}

       	in = new Scanner(new File(args[0]));
	
	//Vector v = new Vector(0);
	while( in.hasNextLine() ){
	    lineNumber++;
	    line = in.nextLine()+" ";
	}

	in.close();
	
	in = new Scanner(new File(args[0]));
	
		
	String[] s = new String[lineNumber];
	for (int i = 0; i < lineNumber; i++) {
	    line = in.nextLine() + " ";
	    s[i] = line;
	    //	    System.out.println(s[i]);
	}

	in.close();

	List L = new List();
	L.append(0);

	for (int i = 1; i < s.length; i++) {
	    L.moveFront();
	    if (s[i].compareTo(s[L.front()]) < 0) {
		L.prepend(i); // prepend if < first element
		continue;
	    }
	    
	    if (s[i].compareTo(s[L.back()]) > 0) {
		L.append(i); // append if > last element
		continue;
	    }
	    
	    while (L.index() != -1) {
		if (s[i].compareTo(s[L.get()]) > 0) {
		    L.moveNext();
		  
		}
		else {
		    L.insertBefore(i);
		    break;
		}
	    }

	}

	out = new PrintWriter(new FileWriter(args[1]));
	
	L.moveFront();
	while (L.index() >= 0) {
	    out.println(s[L.get()]);
	    L.moveNext();
	}
	
	out.close();

	//       	L.moveFront();
	//	System.out.println(L);
    }
}
