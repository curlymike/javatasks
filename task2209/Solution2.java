package com.javarush.task.task22.task2209;

import java.io.*;
import java.util.*;

/*
Составить цепочку слов
*/
public class Solution2 {
  public static void main(String[] args) {
    //...
    String fileName;

//    BufferedReader cbr = new BufferedReader(new InputStreamReader(System.in));
//    try {
//      fileName = cbr.readLine();
//    } catch (IOException e) {
//      e.printStackTrace();
//      return;
//    }

    // C:\Temp\JavaRush_test_files\task2209_1.txt
    fileName = "C:\\Temp\\JavaRush_test_files\\task2209_1.txt";
    //fileName = "C:\\Temp\\JavaRush_test_files\\task2209_1_1.txt";
    //fileName = "C:\\Temp\\JavaRush_test_files\\task2209_2.txt";
    //fileName = "C:\\Temp\\JavaRush_test_files\\task2209_3.txt";
    //fileName = "C:\\Temp\\JavaRush_test_files\\task2209_4.txt";
    //fileName = "C:\\Temp\\JavaRush_test_files\\task2209_pairs.txt";
    //fileName = "C:\\Temp\\JavaRush_test_files\\task2209_two_sets.txt";

    String line = "";
    StringBuilder sb = new StringBuilder();

    try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

      //StringBuffer sb = new StringBuffer();
      //sb.append(br.readLine());

      while ((line = br.readLine()) != null) {
        if (sb.length() > 0) {
          sb.append(" ");
        }
        sb.append(line);
      }

    } catch (FileNotFoundException e) {
      e.printStackTrace();
      return;
    } catch (IOException e) {
      e.printStackTrace();
      return;
    }

    line = sb.toString();

    StringBuilder result = getLine(line.split("\\s+"));
    System.out.println(result.toString());
  }

  /***************************************
   * @param words
   * @return
   ***************************************/

  public static StringBuilder getLine(String... words) {

    System.out.println(String.join(" ", words));
    System.out.println("----------------------------------------");

    StringBuilder sb = new StringBuilder("");

    if (words == null || words.length == 0) {
      return sb;
    }

    if (words.length == 1) {
      sb.append(words[0]);
      return sb;
    }

    Arrays.sort(words);
    //sortWords(words);

//    for (String word : words) {
//      System.out.println(word);
//    }

//    int first = firstWord(words);

    sb = Brute4(words);
//    sb = Brute4(words, first);

    return sb;
  }

  /***************************************
   *
   ***************************************/

  public static int firstWord(String[] words) {
    int indx = 0;
    for (int i = 1; i < words.length; i++) {
      if (words[indx].compareTo(words[i]) > 0) {
        indx = i;
      }
    }
    return indx;
  }

  /***************************************
   *
   ***************************************/

  public static void sortWords(String[] words) {
    for (int i = 0; i < words.length - 1; i++) {
      for (int f = i; f < words.length; f++) {
        if (words[i].compareTo(words[f]) > 0) {
          String tmp = words[i];
          words[i] = words[f];
          words[f] = tmp;
        }
      }
    }
  }

  /***************************************
   *
   ***************************************/


  public static char firstChar(String str) {
    return str.substring(0, 1).toUpperCase().charAt(0);
  }

  //-------------------------

  public static char lastChar(String str) {
    return str.substring(str.length() - 1).toUpperCase().charAt(0);
  }

  /*******************************************
   * @param words - array of Strings representing words
   * @param index - index of the word for which to find compatible words for
   * @return int[] - array of indexes (could be empty)
   */

  public static int[] findRightCompatible(String[] words, int index) {
    ArrayList<Integer> arr = new ArrayList<Integer>();
    // This technically may result in IndexOutOfBoundsException

    char chr1 = lastChar(words[index]);

    //System.out.print("findRightCompatible(): " + chr1 + " : ");

    for (int i = 0; i < words.length; i++) {
      if (i == index) {
        continue;
      }
      char chr2 = firstChar(words[i]);
      if (chr1 == chr2) {
        arr.add(i);
      }
    }

    //System.out.println();
    //System.out.println("findRightCompatible(): " + words[index] + " (" + index + ", " + words.length + ") " + arr.size());

    int[] arr2 = new int[arr.size()];
    for (int i = 0; i < arr.size(); i++) {
      arr2[i] = arr.get(i);
    }
    return arr2;
  }

  /****************************************
   *
   ****************************************/

  public static class Word {
    protected static int count;
    protected static int stepMax;

    protected Word parent;

    protected int number;
    protected int step;
    protected int index;

    public Word(int index) {
      this(index, null);
    }

    public Word(int index, Word parent) {
      this.index = index;
      this.parent = parent;
      this.step = parent == null ? 0 : parent.step() + 1;
      if (this.step > this.stepMax) {
        this.stepMax = this.step;
      }
      this.number = count++;
    }

    public int i() {
      return this.index;
    }

    public int index() {
      return this.index;
    }

    public int step() {
      return this.step;
    }

    public int stepMax() {
      return this.stepMax;
    }

    public Word getParent() {
      return this.parent;
    }

    public String toString() {
      return "#" + this.number + " " + this.index + "; parent: " + (this.parent == null ? "null" : "#" + this.parent.i());
    }

  }

  /**************************************
   *
   **************************************/

  public static StringBuilder Brute4(String... words) {
    return Brute4(words, 0);
  }

  //---------------------------------------------

  public static StringBuilder Brute4(String[] words, int first) {
//    System.out.println(String.join(" ", words));
//    System.out.println("----------------------------------------");
//    for (String word : words) {
//      System.out.println("> " + word);
//    }
//    System.out.println("----------------------------------------");

    StringBuilder sb = new StringBuilder();

    ArrayList<Word> combos = new ArrayList<Word>();
    ArrayDeque<Word> queue = new ArrayDeque<Word>();

    //int first = 2;

    queue.add(new Word(first));
    combos.add(new Word(first));

    while (!queue.isEmpty()) {
      Word w = queue.pop();
      int[] mtch = findRightCompatible(words, w.i());

//      System.out.print(words[w.i()] + " : ");
//      for (int f : mtch) {
//        System.out.print(words[f] + " ");
//      }
//      System.out.println();

      for (int f : mtch) {
        if (wordIsAvailable(w, f)) {
          Word newWord = new Word(f, w);
          combos.add(newWord);
          queue.addLast(newWord);
        }
      }
    }

    int longest = combos.get(0).stepMax();

//    System.out.println("combos.size(): " + combos.size());
//    System.out.println("Longest trail: " + longest);
//    System.out.println();

//    for (Word w : combos) {
//      if (w.step() == longest) {
//        printWordTrail(words, w);
//        //ArrayList<Integer> rest = rest(words, w);
//        ArrayList<Integer> rest = getRest(words, w);
//        System.out.println("rest: " + (rest.size() == 0 ? "none" : getRestString(words, w)));
//      }
//    }

    for (Word w : combos) {
      if (w.step() == longest) {
        sb = getWordTrailSB(words, w);
        String rest = getRestString(words, w);
        if (rest.length() > 0) {
          sb.append(" " + rest);
        }
        break;
      }
    }

    return sb;
  }

  /***************************************
   *
   ***************************************/

  public static boolean wordIsAvailable(Word word, int i) {
    //System.out.println(word);
    while (word != null) {
      Word parent = word.getParent();
      if (parent != null && parent.i() == i) {
        return false;
      }
      word = parent;
    }

    return true;
  }

  /***************************************
   *
   ***************************************/

  public static void printWordTrail(String[] words, Word word) {
    System.out.println(getWordTrailSB(words, word).toString());
  }

  //----------------------------------

  public static StringBuilder getWordTrailSB(String[] words, Word word) {
    ArrayList<Integer> indx = getWordTrail(words, word);
    StringBuilder sb = new StringBuilder();
    for (int i = indx.size() - 1; i >= 0; i--) {
      if (sb.length() > 0) {
        sb.append(" ");
      }
      sb.append(words[indx.get(i)]);
    }
    return sb;
  }

  //--------------------------------------------------

  public static ArrayList<Integer> getWordTrail(String[] words, Word word) {
    ArrayList<Integer> indx = new ArrayList<Integer>();
    while (word != null) {
      indx.add(word.i());
      word = word.getParent();
    }
    return indx;
  }

  //------------------------------------

  public static ArrayList<Integer> getRest(String[] words, Word word) {
    ArrayList<Integer> t = getWordTrail(words, word);
    ArrayList<Integer> r = new ArrayList<Integer>();
    for (int i = 0; i < words.length; i++) {
      if (!t.contains(i)) {
        r.add(i);
      }
    }
    return r;
  }

  //------------------------------------

  public static String getRestString(String[] words, Word word) {
    ArrayList<Integer> r = getRest(words, word);
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < r.size(); i++) {
      if (sb.length() > 0) {
        sb.append(" ");
      }
      sb.append(words[r.get(i)]);
    }
    return sb.toString();
  }

  /******************************************
   *
   ******************************************/

}
