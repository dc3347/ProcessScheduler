import java.util.Arrays;
import java.util.*;

public class MergeSort {

  /**
   * Method that merges two sorted halves of a subarray (from Weiss,
   * Data Structures and Algorithm Analysis in Java)
   * 
   * @param a
   *          an array of Comparable items.
   * @param tmpArray
   *          an array to place the merged result.
   * @param leftPos
   *          the left-most index of the subarray.
   * @param rightPos
   *          the index of the start of the second half.
   * @param rightEnd
   *          the right-most index of the subarray.
   */
  private static void merge(Integer[] a, Integer[] tmp, int leftPos, int rightPos, int rightEnd) {
        int aCtr = leftPos;
        int bCtr = rightPos; 
        int cCtr = leftPos; 

        while (aCtr < rightPos && bCtr <= rightEnd) {
            
            if (a[aCtr] <= a[bCtr]) 
                tmp[cCtr++] = a[aCtr++];
            else 
                tmp[cCtr++] = a[bCtr++];
        }
        
        if (aCtr >= rightPos )  // copy remaining elements in right partion 
            while (bCtr <= rightEnd) 
                tmp[cCtr++] = a[bCtr++];

        if (bCtr > rightEnd ) // copy remaining elements in left partion
            while (aCtr < rightPos) 
                tmp[cCtr++] = a[aCtr++]; 
            
        for (int i=leftPos; i<=rightEnd; i++) {
            a[i] = tmp[i];
        }
  }

 
  /* 
   * @param a
   *          an array of Comparable items.
   * @param tmpArray
   *          an array to place the merged result.
   * @param left
   *          the left-most index of the subarray.
   * @param right
   *          the right-most index of the subarray.
   */
  private static void mergeSort(Integer[] inputArray) {
      Integer[]a=inputArray;
      Integer[]tmp=new Integer[a.length];
      int sz;
    
      for(sz=1;sz<a.length;sz*=2){
          for(int lo=0;lo<a.length-sz;lo+=2*sz){
              int hi=Math.min(lo+sz+sz-1, a.length-1);
              int mid=lo+sz;
              if(lo!=mid){
                  mid=lo+sz;
                  merge(a,tmp,lo,mid,hi);
              }
                      
           }
                   
      }    
      sz=sz/2;
      if(sz>=a.length){
          merge(a,tmp,0,sz,a.length-1);
      }
      
  }

  public static void main(String[] args) {
      Integer[] a = {12, 12, 23, 4 , 6, 6, 10, -35, 28};
      System.out.println(Arrays.toString(a)); 
      MergeSort.mergeSort(a);
      System.out.println(Arrays.toString(a)); 

      Integer[] b = {3,3,9,2,5,1};
      System.out.println(Arrays.toString(b)); 
      MergeSort.mergeSort(b);
      System.out.println(Arrays.toString(b));

      Integer[] d = {0,0,0,4,2,3,4,5,6,2};
      System.out.println(Arrays.toString(d)); 
      MergeSort.mergeSort(d);
      System.out.println(Arrays.toString(d)); 
  }
}
