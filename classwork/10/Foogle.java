/**
   classwork -- Day 10 | 0b1010 | 0x10
   class: indexOfgle
   A tester class for code analysis and search exploration.
   USAGE:
   Read through at least once.
   Compile, run.
   Comment/uncomment lines, recompile, run to explore functionality.
   "Lather, rinse, repeat" until comprehension achieved.
   Rename methods to indicate purpose.
   Insert comment preceding each method to summarize functionality.
   T. Mykolyk, F. Dragon
   June 2020
**/

import java.io.*;
import java.util.*;

public class indexOfgle
{

  //  indexOf target if it exists. Traverses ArrayList until element matches target, then returns that index. If not found, returns -1
  public static int indexOf( ArrayList al, int target )
  {
    for( int pos=0; pos<al.size(); pos++) {
      if (al.get(pos).equals(target))
        return pos;
    }
    return -1;
  }//end indexOf()


  //  populates an ArrayList with custom number of items with integer numbers between lo and hi
  public static ArrayList randPopArray(int numItems, int lo, int hi)
  {
    ArrayList retArr = new ArrayList();

    for(int i=0; i<numItems; i++) {
      //System.out.println(i);  //diagnostic under-the-hood view
      //retArr.add( Math.random() ); // [0,1)
      //retArr.add( (int)Math.random() ); //0
      //retArr.add( (int)(hi * Math.random()) ); // [0,hi)
      retArr.add( lo + (int)(hi * Math.random()) ); // [lo,hi)
    }
    return retArr;
  }//end randPopArray()


  //  initializes an ArrayList with a random number to the 0th index that is between 0 and lo, then adds items that are floored by prior index's value with a ceiling that is a random number less than lo + hi.
  public static ArrayList preAddRand(int numItems, int lo, int hi)
  {
    ArrayList retArr = new ArrayList();

    // If no number of items, return empty array
    if ( numItems<1 )
      return retArr;

    // intializes 0th index to a random number that is between 0 and lo
    retArr.add( (int)(lo * Math.random()) );

    // 
    for(int i=1; i<numItems; i++) {
      //System.out.println(i);  //diagnostic under-the-hood view
      //retArr.add( Math.random() ); // [0,1)
      //retArr.add( (int)Math.random() ); //0
      //retArr.add( (int)(hi * Math.random()) ); // [0,hi)
      //retArr.add( lo + (int)(hi * Math.random()) ); // [lo,hi)
      //System.out.println(retArr.get(i-1));  //diag.
      retArr.add( (int)retArr.get(i-1)
                  + lo + (int)(hi * Math.random()) );
    }

    return retArr;
  }//end preAddRand()


  public static void main( String[] args )
  {
    // test battery for randPopArray()
    /*~~~~v~~~~~~move~me~down~~~1~block~at~a~time~~~~~~~~~~v~~~~
    System.out.println("\n"+"al000"+":");
    ArrayList al000 = randPopArray(0,0,0);
    System.out.println(al000);
    System.out.println(indexOf(al000,3));
    System.out.println("\n"+"al01"+":");
    ArrayList al01 = randPopArray(5,0,100);
    System.out.println(al01);
    System.out.println(indexOf(al01,3));
    System.out.println("\n"+"al02"+":");
    ArrayList al02 = randPopArray(5,3,10);
    System.out.println(al02);
    System.out.println(indexOf(al02,3));
    System.out.println("\n"+"al05"+":");
    ArrayList al05 = randPopArray(20,1,5);
    System.out.println(al05);
    System.out.println(indexOf(al05,3));
      ~~~~^~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~^~~~~*/


    // test battery for preAddRand()
    /*~~~~v~~~~~~move~me~down~~~1~block~at~a~time~~~~~~~~~~v~~~~
    System.out.println("\n"+"sal000"+":");
    ArrayList sal000 = preAddRand(0,0,0);
    System.out.println(sal000);
    System.out.println(indexOf(sal000,3));
    System.out.println("\n"+"sal00"+":");
    ArrayList sal00 = preAddRand(5,0,100);
    System.out.println(sal00);
    System.out.println(indexOf(sal00,3));
    System.out.println("\n"+"sal01"+":");
    ArrayList sal01 = preAddRand(5,0,100);
    System.out.println(sal01);
    System.out.println(indexOf(sal01,3));
    System.out.println("\n"+"sal02"+":");
    ArrayList sal02 = preAddRand(5,3,100);
    System.out.println(sal02);
    System.out.println(indexOf(sal02,3));
    System.out.println("\n"+"sal03"+":");
    ArrayList sal03 = preAddRand(5,0,100);
    System.out.println(sal03);
    System.out.println(indexOf(sal03,3));
    System.out.println("\n"+"sal04"+":");
    ArrayList sal04 = preAddRand(20,0,3);
    System.out.println(sal04);
    System.out.println(indexOf(sal04,3));
    System.out.println("\n"+"sal05"+":");
    ArrayList sal05 = preAddRand(20,1,5);
    System.out.println(sal05);
    System.out.println(indexOf(sal05,3));
      ~~~~^~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~^~~~~*/

    /*
    System.out.println("\n"+"al"+":");
    ArrayList al = randPopArray(,0,100);
    System.out.println(al);
    */
  }//end main

}//end class