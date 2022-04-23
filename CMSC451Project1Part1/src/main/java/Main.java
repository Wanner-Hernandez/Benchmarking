/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * File: Main.java
 * Authoor : Wanner HernandezR
 * Professor: Didulo, Dennis
 * Date: June 13,2021
 * Description: Performs JVM warm up and then runs the benchmark
 */
public class Main {

  public static void main(String[] args) throws UnsortedException {
    // defines input sizes
    int[] sizes = new int[]{100, 200, 300, 400, 500, 1000, 2000, 3000, 4000, 5000};

    BenchmarkSorts warmUp = new BenchmarkSorts(sizes);
    warmUp.runBenchmark();
  }
}

