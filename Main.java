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