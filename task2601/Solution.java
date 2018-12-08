

import java.util.Arrays;
import java.util.Comparator;

/*
Почитать в инете про медиану выборки
*/
public class Solution {

    public static void main(String[] args) {
//      Integer[] test = new Integer[]{13, 8, 15, 5, 17};
//      Integer[] test = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8};
//      sort(test);
//      for (Integer i : test) {
//        System.out.println(i);
//      }
    }

    public static Integer[] sort(Integer[] array) {
      Arrays.sort(array);
      int m; // mediana
      if (array.length % 2 == 0) {
        int mIndex = array.length / 2;
        m = (array[mIndex] + array[mIndex - 1]) / 2;
      } else {
        m = array[array.length / 2];
      }
      Arrays.sort(array, Comparator.comparingInt(a -> Math.abs(a - m)));
      return array;
    }
}
