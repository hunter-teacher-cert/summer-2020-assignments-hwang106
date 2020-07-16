/**
   classwork -- Day 10 | 0b1010 | 0x10
   class: Boogle
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

public class Boogle
{


  //return index of first occurence of target, or -1 if not found
  public static int linSearch( ArrayList al, int target )
  {
    for( int pos=0; pos<al.size(); pos++) {
      if (al.get(pos).equals(target))
        return pos;
    }
    return -1;
  }//end linSearch()








  //return index of target, or -1 if not found
  public static int binSearch( ArrayList al, int target )
  {
    // <INSERT YOUR MACHINERY HERE>...
    return -1; //placeholder to get past compiler
  }//end binSearch()



  // subgoal: recognize target found (and take what action?)
  // subgoal: recognize search space exhausted (and take what action?)
  // subgoal: recognize target in lower portion of range (and do what?)
  // subgoal: recognize target in upper portion of range (and do what?)

  //nota bene: A helper method could be very useful.
  // Q: Why?
  // Q: What would the parameters be for such a method?



  //return ArrayList of random ints on range [lo,lo+hi)
  public static ArrayList prestoArrayListo(int numItems, int lo, int hi)
  {
    ArrayList retArr = new ArrayList();

    for(int i=0; i<numItems; i++) {
      //System.out.println(i);  //diagnostic under-the-hood view
      //retArr.add( Math.random() ); // [0,1)
      //retArr.add( (int)Math.random() ); // 0
      //retArr.add( (int)(hi * Math.random()) ); // [0,hi)
      retArr.add( lo + (int)(hi * Math.random()) ); // [lo,lo+hi)
    }
    return retArr;
  }//end prestoArrayListo()


  //return ArrayList of random ints, sorted in ascending order
  public static ArrayList prestoSortedArrayListo(int numItems,
                                                 int lo, int hi)
  {
    ArrayList retArr = new ArrayList();

    //if requested, return empty ArrayList
    if ( numItems<1 )
      return retArr;

    //populate index 0
    retArr.add( (int)(lo * Math.random()) );

    //populate rest of indices, each one greater than last
    for(int i=1; i<numItems; i++) {
      //System.out.println(i);  //diagnostic under-the-hood view
      //retArr.add( Math.random() ); // [0,1)
      //retArr.add( (int)Math.random() ); // 0
      //retArr.add( (int)(hi * Math.random()) ); // [0,hi)
      //retArr.add( lo + (int)(hi * Math.random()) ); // [lo,lo+hi)
      //System.out.println(retArr.get(i-1));
      retArr.add( (int)retArr.get(i-1)
                  + lo + (int)(hi * Math.random()) ); // ["left neighbour",hi)
    }

    return retArr;
  }//end prestoSortedArrayListo()

  //##################################################
  //##################################################

    // find and return the index of the smallest value in the
    // ArrayList al from index lo to index hi inclusive 
   public static int findSmallest(ArrayList<Integer> al, int lo, int hi){
	// assume the first item is the smallest - call it our smallest so far
	int size = al.size();
		if (lo < 0 || hi < 0 || lo >= size || hi >= size){
			throw new IndexOutOfBoundsException("You picked an lo or hi that is not within the bounds of the array");
		}
		
		if (lo > hi){
			throw new IndexOutOfBoundsException("Lo can't be greater than Hi");
		}
		
		
		int min = (int) al.get(lo);
		int minIndex = lo;

		// loop over all the items
		for (int i = 1 + lo; i <= hi; i++){
			int temp = (int) al.get(i);
			if (temp < min){
				min = temp;
				minIndex = i;
			}
		}

		return minIndex; 

    }
	
	/*/	
	public static void selectionSort(ArrayList<Integer> al){
		
		//store size of array
		int hi = al.size() - 1;
		int tempLoValue;
		int smallestIndex;
		int smallestValue;
		
		//create loop where lo increments, and lo represents the lo parameter for findSmallest only needs to go to hi - 1, since the last doesn't need to be sorted
		for (int lo = 0; lo < hi; lo++){
			//run findSmallest on entire array and store the Index and the value
			smallestIndex = findSmallest(al, lo, hi);
			smallestValue = al.get(smallestIndex);
			//store the low index value in a temp variable
			tempLoValue = al.get(lo);
			//replace low index value with value of found Index
			al.set(lo, smallestValue);
			//replace original index value with stored temp variable
			al.set(smallestIndex, tempLoValue);
		}
	}//*/
	
	// This version uses swap helper method
	public static void selectionSort(ArrayList<Integer> al){	
		//store size of array
		int hi = al.size() - 1;
		
		if (al == null || hi < 1){ //Margie's idea, which came from Tsee
			return; 
		}
		
		int smallestIndex;
		
		//create loop where lo increments, and lo represents the lo parameter for findSmallest only needs to go to hi - 1, since the last doesn't need to be sorted
		for (int lo = 0; lo < hi; lo++){
			//run findSmallest on entire array and store the Index and the value
			smallestIndex = findSmallest(al, lo, hi);
			if (smallestIndex != lo) //Bob's idea that there no need to swap if you are already at the smallest index
				swap(al, lo, smallestIndex);
		}
	}//*/
	
	public static void swap(ArrayList<Integer> al, int index1, int index2){
		
		if (al == null || index1 < 0 || index1 >= al.size() || index2 < 0 || index2 >= al.size()){
			throw new IndexOutOfBoundsException();
		}
		
		int value1 = al.get(index1);
		int value2 = al.get(index2);
		
		al.set(index1, value2);
		al.set(index2, value1);
	}
	
	/*/
	public static void mergeSort(ArrayList<Integer> al){

		//base case 
		if (al.size() == 1){
			return;
		}
		
		//create new arrays that are subsets of the original array
		int midIndex = al.size()/2;
		
		ArrayList<Integer> subal1 = new ArrayList<Integer>(al.subList(0, midIndex));
		ArrayList<Integer> subal2 = new ArrayList<Integer>(al.subList(midIndex + 1, (midIndex * 2) - 1));
		
		mergeSort(subal1);
		mergeSort(subal2);
		
		while (al1.size() > 0 || al2.size() > 0){
			if (al1.get(0)>al2.get(0)){
				
			}
		}
		
	}//*/
	
	public static ArrayList<Integer> merge(ArrayList<Integer> a, ArrayList<Integer> b){
		ArrayList<Integer> merged = new ArrayList<Integer>();
		int aSize = a.size();
		int bSize = b.size();
		int aLo = 0;
		int bLo = 0;
		
		while (aLo < aSize && bLo < bSize){
			if (a.get(aLo) <= b.get(bLo)){
				merged.add(a.get(aLo));
				aLo++;
			}
			else{
				merged.add(b.get(bLo));
				bLo++;
			}	
		}
		
		if (aLo == aSize){
			while (bLo < bSize){
				merged.add(b.get(bLo));
				bLo++;
			}
		}
		
		else{
			while (aLo < aSize){
				merged.add(a.get(aLo));
				aLo++;
			}
		}
		
		return merged;
	}


  //##################################################
  //##################################################

//
  public static void main( String[] args )
  {

      
      int smallIndex;
      System.out.println("Testing findSmallest");
      ArrayList<Integer>  slist = prestoArrayListo(20,0,200);
	  ArrayList<Integer>  slist2 = prestoArrayListo(20,0,200);
      //smallIndex = findSmallest(slist,0,slist.size()-1);
	  //smallIndex = findSmallest(slist,20,slist.size());
      //System.out.println(slist);
      //System.out.printf("Smallest is at slist[%d] and is %d\n",smallIndex,slist.get(smallIndex));
	  selectionSort(slist);
	  selectionSort(slist2);
	  System.out.println(slist);
	  System.out.println(slist2);
      System.out.println(merge(slist, slist2))	;


}//end main

}//end class