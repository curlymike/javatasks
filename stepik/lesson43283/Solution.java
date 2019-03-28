package stepik.lesson43283;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

class Solution {
  public static void main(String[] args) throws Exception {
    // put your code here
    readFlipAndPrint(System.in);
  }

  public static void readFlipAndPrint(InputStream is) throws IOException {
    Map<String, Set<String>> dict = readAndFlip(is);
    System.out.println(dict.size());
    for (Map.Entry<String, Set<String>> pair : dict.entrySet()) {
      System.out.println(pair.getKey() + " - " + String.join(", ", pair.getValue()));
    }
  }

  public static Map<String, Set<String>> readAndFlip(InputStream is) throws IOException {
    Map<String, Set<String>> dict = new TreeMap<>();
    try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
      int numberOfLines = Integer.parseInt(br.readLine());
      for (int i = 0; i < numberOfLines; i++) {
        String[] str = br.readLine().split(" - ", 2);
        String[] latin = str[1].split(", ");
        for (String latinWord : latin) {
          dict.computeIfAbsent(latinWord, k -> new TreeSet<>()).add(str[0]);
        }
      }
    }
    return dict;
  }
}

