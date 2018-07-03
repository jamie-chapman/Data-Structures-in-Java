import java.util.Random;
import java.util.Arrays;
/**
 * Created by Jamie on 02/05/2017.
 * Experiment to implement a Binary Search Tree in Java
 */
public class AssignmentMain
{
    //Setup
    static int[] pathSizes = new int[1000];
    static int[] dataSize = new int[1000];
    static int paths = 0;

    public static void main(String[] args)
    {
        BSTcompute();
        SortedArrayCompute();
    }

    public static void SortedArrayCompute()
    {
        for(int trials = 0; trials <= 999; trials++) {
            //setup
            Random rand = new Random();
            final int N = rand.nextInt(10000) + 100;
            //Array of size N
            int[] array = new int[N];

            //Insert random numbers 0 to n into array positions
            for (int i = 0; i < N - 1; i++) {
                array[i] = rand.nextInt(N) + 1;
            }

            SelectionSorter s = new SelectionSorter(array);
            s.sort();

            //Get random number inside array
            int target = array[rand.nextInt(N)];
            dataSize[trials] = N;
            pathSizes[trials] = s.binarySearch(target);
            paths = paths + pathSizes[trials];
        }

        paths = paths/1000;
        System.out.println("\n\nSorted Array Average number of paths after 1000 trials :> " + paths);

        //Analysis
        SelectionSorter p = new SelectionSorter(pathSizes);
        p.sort();
        pathSizes = p.getArray();

        SelectionSorter t = new SelectionSorter(dataSize);
        t.sort();
        dataSize = t.getArray();

        System.out.println("DataSize...");
        for(int trials = 0; trials <= 999; trials++)
        {
            System.out.print(dataSize[trials] + " ");
        }

        System.out.println("\nPathSizes...");
        for(int trials = 0; trials <= 999; trials++)
        {
            System.out.print(pathSizes[trials] + " ");
        }

    }

    public static void BSTcompute()
    {
        for(int trials = 0; trials <= 999; trials++)
        {
            BinarySearchTree tree = new BinarySearchTree();
            Random rand = new Random();
            final int N = rand.nextInt(10000) + 100;
            //Array of size N
            int[] array = new int[N];

            //Insert random numbers 0 to n into array positions
            for (int i = 0; i < N-1; i++) {
                array[i] = rand.nextInt(N) + 1;
            }

            //Get random number inside array
            int target = array[rand.nextInt(N)];

            //System.out.println("N :> " + N);
            //System.out.println("Target :> " + target);

            for (int i = 1; i < N; i++) {
                tree.insert(array[i]);
            }

            //tree.display(tree.root);

            //System.out.println("\n\nFinding target...");
            dataSize[trials] = N;
            pathSizes[trials] = tree.findCount(target);
            paths = paths + pathSizes[trials];
            //System.out.print("Number of paths taken to find target :> " + paths);
        }

        paths = paths/1000;
        System.out.println("BST Average number of paths after 1000 trials :> " + paths);

        //Analysis
        SelectionSorter p = new SelectionSorter(pathSizes);
        p.sort();
        pathSizes = p.getArray();

        SelectionSorter t = new SelectionSorter(dataSize);
        t.sort();
        dataSize = t.getArray();

        System.out.println("dataSize...");
        for(int trials = 0; trials <= 999; trials++)
        {
            System.out.print(dataSize[trials] + " ");
        }

        System.out.println("\nPathSizes...");
        for(int trials = 0; trials <= 999; trials++)
        {
            System.out.print(pathSizes[trials] + " ");
        }
    }
}


