/**
**/

import java.io.*;
import java.util.*;

public class SSorter
{


  //return ArrayList of random ints on range [lo,lo+hi)
  public static ArrayList<Integer> prestoArrayListo(int numItems, int lo, int hi)
  {
    ArrayList<Integer> retArr = new ArrayList<Integer>();

    for(int i=0; i<numItems; i++) {
      //System.out.println(i);  //diagnostic under-the-hood view
      //retArr.add( Math.random() ); // [0,1)
      //retArr.add( (int)Math.random() ); // 0
      //retArr.add( (int)(hi * Math.random()) ); // [0,hi)
      retArr.add( lo + (int)(hi * Math.random()) ); // [lo,lo+hi)
    }
    return retArr;
  }//end prestoArrayListo()


  //##################################################
  //##################################################

  // find and return the index of the smallest value in the
  // ArrayList al from index lo to index hi inclusive
  public static int findSmallest(ArrayList<Integer> al, int lo, int hi){
    int maxIndexSoFar = lo;
    for (int i = lo; i <=hi; i++) {
      if (al.get(i) < al.get(maxIndexSoFar)){
        maxIndexSoFar = i;
      }
    }
    return maxIndexSoFar;
  }

  public static ArrayList<Integer> selectionSort(ArrayList<Integer> al) {

    int lo = 0;
    int temp;

    for (int i=0; i < al.size() - 1; i++) {
      lo = findSmallest(al, i, al.size()-1);
      temp = al.get(i);
      al.set(i, al.get(lo));
      al.set(lo, temp);
    }
	
	return al;

  }//selectionSort
  
	public static ArrayList<Integer> merge(ArrayList<Integer> a, ArrayList<Integer> b){
		//initialize variables: new ArrayList object, sizes of ArrayList inputs, indices initialized to 0
		ArrayList<Integer> merged = new ArrayList<Integer>();
		int aSize = a.size(); 
		int bSize = b.size();
		int aLo = 0;
		int bLo = 0;
		
		//create loop that runs unless aLo index or bLo index has reached the end of the Arraylist
		while (aLo < aSize && bLo < bSize){
			//set up conditional that compares the smallest values of each ArrayList and adds the smaller one to merged ArrayList
			if (a.get(aLo) <= b.get(bLo)){
				merged.add(a.get(aLo));
				aLo++;
			}
			else{
				merged.add(b.get(bLo));
				bLo++;
			}	
		}
		
		//clean up for adding the remaining elements of the other array
		if (aLo == aSize){//conditional actually not necessary, since the while loop will take care of it
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

  public static ArrayList<Integer> slice(ArrayList<Integer> al, int lo, int hi) {
	//creates new ArrayList object to place old ArrayList objects into
    ArrayList<Integer> sub = new ArrayList<Integer>();
    
	for (; lo < hi; lo++) { //loop that takes elements from lo to hi from all and places them into sub
      sub.add( al.get(lo) ); 
    }//copy
    return sub; 
  }//slice
  
  
  //recursive method to divide list until base case and then merge the sorted lists until one list
  public static ArrayList<Integer> mergeSort(ArrayList<Integer> al){
	int size = al.size();
	
	/* if (size == 1){
		return al;
	} */
	
	//base case if you really wanted to sort the last 2/3 without going down to one element
	if (size == 2 || size == 3){
		return selectionSort(al);
	}
	
	int midIndex = size / 2;
	
	ArrayList<Integer> branch1 = mergeSort(slice(al, 0, midIndex)); //slice method is inclusive of lower bound (0) and exclusive of upper bound (midIndex)
	ArrayList<Integer> branch2 = mergeSort(slice(al, midIndex, size)); //inclusive of midIndex and exclusive of size
	
	return merge(branch1, branch2);
	
  }



  //##################################################
  //##################################################

  public static void main( String[] args )
  {
    ArrayList<Integer> randos = prestoArrayListo(20, 0, 100);
	
	System.out.println(randos);
	System.out.println(mergeSort(randos));

    // System.out.println(randos);

    //long start = System.currentTimeMillis();

    //selectionSort(randos);

    //long elapsed = System.currentTimeMillis() - start;
	
    // System.out.println(randos);
    //System.out.println("Elapsed time: " + elapsed);
    
  }//*/
  
 /*/ public static void main( String[] args ) {
    
	//merging topher test
	for( int n=2; n<=10; n += 2 ) {
			ArrayList tpe = prestoArrayListo(n,1,5);
			ArrayList ohr = prestoArrayListo(n,1,5);
			ArrayList topher = merge(tpe, ohr);
			System.out.println("\ntpe" + n + " = " + tpe);
			System.out.println("ohr" + n + " = " + ohr);
			System.out.println("topher" + (2*n) + " = " + topher);
			System.out.println("top" + n + " = " + slice(topher, 0, topher.size()/2));
			System.out.println("her" + n + " = " + slice(topher, topher.size()/2, topher.size()));
	}
	
}//*/

}//end class