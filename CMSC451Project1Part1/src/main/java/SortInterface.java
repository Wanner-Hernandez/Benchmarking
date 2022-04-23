/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * File: SortInterface.java
 * Authoor : Wanner HernandezR
 * Professor: Didulo, Dennis
 * Date: June 13,2021
 * Description: interface for different
 * sorting algorithms. 
 * This interface defines the required methods.
 */
public interface SortInterface {

  void recursiveSort(int[] list) throws UnsortedException;

  void iterativeSort(int[] list) throws UnsortedException;

  int getCount();

  long getTime();
}
