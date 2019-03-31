package Stepik.adaptive.lesson43247;

import java.util.Scanner;

/***
 * 1.131 Spiral
 * https://stepik.org/lesson/43247/step/1?adaptive=true&unit=21311
 * (Solution accepted)
 */

public class Main {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    print(spiral(s.nextInt()));
  }

  public static void print(int[][] m) {
    for (int i = 0; i < m.length; i++) {
      for (int f = 0; f < m[i].length; f++) {
        //System.out.print(String.format("%02d ", m[i][f]));
        System.out.print(m[i][f] + " ");
      }
      System.out.println();
    }
  }

  public static int[][] spiral(int n) {
    // x, y - coordinates, m is the offset or whind count if you will.
    int[][] matrix = new int[n][n];
    int x = 0, y = 0, whind = 0, count = 0;
    int limit = n * n;

    while (count < limit) {
      for (; x < n - whind; x++) {
        matrix[y][x] = ++count;
      }
      y++;
      x--; // one step back
      for (; y < n - whind; y++) {
        matrix[y][x] = ++count;
      }
      x--;
      y--; // one step back
      for (; x >= 0 + whind; x--) {
        matrix[y][x] = ++count;
      }
      y--;
      whind++;
      x++; // one step back
      for (; y >= 0 + whind; y--) {
        matrix[y][x] = ++count;
      }
      x++;
      y++; // one step back
    }

    return matrix;
  }

}
