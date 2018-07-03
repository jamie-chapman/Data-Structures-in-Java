 /**
    This class sorts an array, using the selection sort algorithm
 */
 public class SelectionSorter
 {
    /**
       Constructs a selection sorter.
       @param anArray the array to sort
    */
    private int[] a;

    public SelectionSorter(int[] anArray)
    {
       a = anArray;
    }
 
    /**
       Sorts the array managed by this selection sorter.
    */
    public void sort()
    {  
       for (int i = 0; i < a.length - 1; i++)
       {  
          int minPos = minimumPosition(i);
          swap(minPos, i);
       }
    }
 
    /**
       Finds the smallest element in a tail range of the array.
       @param from the first position in a to compare
       @return the position of the smallest element in the
       range a[from] . . . a[a.length - 1]
    */
    private int minimumPosition(int from)
    {  
       int minPos = from;
       for (int i = from + 1; i < a.length; i++)
          if (a[i] < a[minPos]) minPos = i;
       return minPos;
    }
 
    /**
       Swaps two entries of the array.
       @param i the first position to swap
       @param j the second position to swap
    */
    private void swap(int i, int j)
    {
       int temp = a[i];
       a[i] = a[j];
       a[j] = temp;
    }

     /**
      * Taken from Horstmanns implementation of a binary search
      * @param target
      * @return
      */
     public int binarySearch(int target)
     {
         int low = 0;
         int high = a.length - 1;
         int count = 0;
         while (low <= high)
         {
             int mid = (low + high) / 2;
             int diff = a[mid] - target;

             if (diff == 0) // a[mid] == target
             {
                 count++;
                 return count;
             }
             else if (diff < 0) // a[mid] < target
             {
                 count++;
                 low = mid + 1;
             }
             else
             {
                 count++;
                 high = mid - 1;
             }
         }
         return 0;
     }

    public int[] getArray()
    {
        return a;
    }
 }

