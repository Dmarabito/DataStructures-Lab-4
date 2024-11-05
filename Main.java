import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
      System.out.println("Unsorted Array ---------------------------------------------------");
      ArrayList<Integer> integerList = Lab4.getList();
      Lab4.outputList(integerList);
      long startTime = System.nanoTime();
      Lab4.insertionSort(integerList);
      long endTime = System.nanoTime();
      System.out.print("\n Insertion sort Time taken: ");
      System.out.print(endTime-startTime); System.out.print(" Nano seconds or "); System.out.print((double)(endTime-startTime)/1000000000); System.out.println(" seconds");
      //Lab4.outputList(integerList);

      System.out.println("\n\nBubble sort results ----------------------------------------------");
      ArrayList<Integer> bubbleSortedList = Lab4.bubbleSort(integerList);
      Lab4.outputList(bubbleSortedList);
      startTime = System.nanoTime();
      Lab4.bubbleSort(bubbleSortedList);
      endTime = System.nanoTime();
      System.out.print("\n BubbleSort Time taken: ");System.out.print(endTime-startTime); System.out.print(" Nano seconds or "); System.out.print((double)(endTime-startTime)/1000000000); System.out.println(" seconds");
      //Lab4.outputList(bubbleSortedList);

      System.out.println("\n\nInsertion sort results -------------------------------------------");
      ArrayList<Integer> insertionSortedList = Lab4.bubbleSort(integerList);
      Lab4.outputList(insertionSortedList);
    }
}

class Lab4 {
  public static ArrayList<Integer> insertionSort(ArrayList<Integer> integerList) {
    // Step 1 - Implement insertion sort algorithm here
    for(int i = 1; i < integerList.size();i++)
    {
      int valueStore = integerList.get(i);
      int backWalk = i-1;
      while (backWalk>=0 && integerList.get(backWalk)>valueStore)
      {
        integerList.set(backWalk+1,integerList.get(backWalk));
        backWalk -=1; 
      }
      integerList.set(backWalk+1,valueStore);
    }
    return integerList;
  }

  public static ArrayList<Integer> bubbleSort(ArrayList<Integer> integerList) {
    // Step 2 - Implement the bubble sort algorithm here
    boolean Swapped = false;
    do {
      Swapped = false; 
      for(int i=0;i<integerList.size()-1;i++)
    {
      if (integerList.get(i)>integerList.get(i+1))
      {
        Swapped = true;
        int Holder = integerList.get(i);
        integerList.set(i, integerList.get(i+1));
        integerList.set(i+1,Holder);
      }
    }
        } while (Swapped == true);
    
    return integerList;
  }

  public static ArrayList<Integer> getList() {
    ArrayList<Integer> integerList = new ArrayList<>();
    String line;
    try (BufferedReader br = new BufferedReader(new FileReader("integers.txt"))) {
        while ((line = br.readLine()) != null) {
            integerList.add(Integer.parseInt(line));
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    return integerList;
  }

  public static void outputList(ArrayList<Integer> integerList) {
    for (int i = 0; i < integerList.size(); i++) {
        System.out.print(integerList.get(i) + " ");
    }
  }
}
/*
 1. If you were implementing a sort algorithm for a new language, which sort would you use?
This fundamentally depends on my purpose for using a sorting algorithm.
How much do I need speed? Insertion sort is rather simple but it is not that efficient.
However if my purpose involves a smaller set, who cares what degree of instantaneous it is?
There is the question of time coding vs time saved in execution.
If for my use case the time saved by deploying a O(nlogn) algorithm vs a O(n^2) is measured in nano seconds than Insertion sort all the way.
However merge sort would probably be my go to for a fast algorithm.
It is a bit chunkier on storage space then some of the similar speed algorithms but it is better than quick sort in the worst case.
Heapsort is also a good option for a faster sort. Now if I want my users to repent I might deploy bogoSort.

2. Was there a difference in the time it took for bubble and insertion sort to run? Does this make sense given the time complexities for these sorting algorithms?
So for perceived time there was not a difference. 
However the time clocked I made a table given below. 
So numerically there is a significant difference in time. 
Insertion is about 100 times slower than bubble sort. 
This does not from a numerical stance align with their big O values. 
Since they should both be O(N^2) on average.

Iteration|Insertion(nanoseconds)|Bubble(nanoseconds)
1        |6,085,900             |46,000
2        |6,011,600             |43,100
3        |6,414,900             |46,400
4        |5,320,100             |45,200
5        |6,042,700             |46,800
6        |5,977,600             |46,300
7        |5,667,600             |44,000
8        |6,002,500             |42,800
9        |5,938,000             |45,600
10       |6,078,900             |39,400

3. Which sort algorithm has an easier implemenation (in terms of understanding) to you?
For me insertion sort is easiest to understand.
 */