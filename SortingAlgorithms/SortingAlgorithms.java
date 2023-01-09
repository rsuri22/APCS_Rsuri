/**
 * Avticity 3.7.6
 */
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.border.EtchedBorder;
import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

public class SortingAlgorithms
{
  /**
   * Perform a selection sort an ArrayList of integers
   * @param intList an ArrayList of integers
   * @return intList sorted from smallest to largest
   */
  public static ArrayList<Integer> selectionSortInt(ArrayList<Integer> intList) {
    for (int i = 0; i < intList.size(); i++) {
      for (int j = intList.size() - 1; j > i; j--) {
        if (intList.get(i) > intList.get(j)) {
          Collections.swap(intList, i, j);
        }
      }
    }
    return intList;
  }

  public static ArrayList<Integer> insertionSortInt(ArrayList<Integer> intList) {
    for (int i = 1; i < intList.size(); i++) {
      int key = intList.get(i);
      int j = i - 1;

      while (j >= 0 && key < intList.get(j)) {
        intList.set((j + 1), intList.get(j));
        j--;
      }
      intList.set(j + 1, key);
    }
    return intList;
  }

  public static ArrayList<Double> selectionSortDouble(ArrayList<Double> doubleList)
  {
    for (int i = 0; i < doubleList.size(); i++) {
      for (int j = doubleList.size() - 1; j > i; j--) {
        if (doubleList.get(i) > doubleList.get(j)) {
          Collections.swap(doubleList, i, j);
        }
      }
    }
    
    return doubleList;
  }

  public static ArrayList<Double> insertionSortDouble(ArrayList<Double> doubleList)
  {
    for (int i = 1; i < doubleList.size(); i++) {
      double key = doubleList.get(i);
      int j = i - 1;

      while (j >= 0 && key < doubleList.get(j)) {
        doubleList.set((j + 1), doubleList.get(j));
        j--;
      }
      doubleList.set(j + 1, key);
    }
    return doubleList;
  }
}