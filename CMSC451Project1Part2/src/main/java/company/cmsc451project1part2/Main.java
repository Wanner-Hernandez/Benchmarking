/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package company.cmsc451project1part2;

/**
* File: Main.java
 * Authoor : Wanner HernandezR
 * Professor: Didulo, Dennis
 * Date: June 13,2021
 * Description: This code will read the files from part one and display 
 * The the second part of the project.
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Main extends JFrame {

  Object[][] tableData = new Object[10][5];
  private DecimalFormat format = new DecimalFormat("#.##");
  String fileName;

  private void processData(String data) {
    Scanner scanner = new Scanner(data);

    for (int i = 0; i < tableData.length; i++) {
      int size = scanner.nextInt();
      double[] timeData = new double[50];
      double[] countData = new double[50];
      for (int j = 0; j < timeData.length; j++) {
        countData[j] = scanner.nextDouble();
        timeData[j] = scanner.nextDouble();
      }
      // set values
      tableData[i][0] = size;
      tableData[i][1] = getMean(countData);
      tableData[i][2] = format.format(getCoef(countData)) + "%";
      tableData[i][3] = getMean(timeData);
      tableData[i][4] = format.format(getCoef(timeData)) + "%";
    }

    scanner.close();
  }

  private double getMean(double[] list) {
    double sum = 0;
    for (double i : list) {
      sum += i;
    }
    return sum / list.length;
  }

  private double getStdDev(double[] list) {
    double sum = 0;
    for (double i : list) {
      sum += (i - getMean(list)) * (i - getMean(list));
    }
    return Math.sqrt(sum / (list.length - 1));
  }

  private double getCoef(double[] list) {
    return ((getStdDev(list)) / getMean(list)) * 100;
  }

  public Main() {

    JFileChooser fileChooser = new JFileChooser();

    int result = fileChooser.showOpenDialog(this);
    if (result == JFileChooser.APPROVE_OPTION) {
      try {
        File file = fileChooser.getSelectedFile();
        fileName = file.getName();
        BufferedReader br = new BufferedReader(new FileReader(file));
        StringBuilder data = new StringBuilder();
        String line = "";
        while ((line = br.readLine()) != null) {
          data.append(line);
        }
        br.close();
        processData(data.toString());
      } catch (IOException e) {
        e.printStackTrace();
      }finally {
      }
    }

    // headers for the table
    String[] columns = new String[]{"Size", "Avg Count", "Coef Count", "Avg Time", "Coef Time"};

    // create table with data
    JTable table = new JTable(tableData, columns);
    this.add(new JScrollPane(table));
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.pack();
    this.setVisible(true);
    this.setTitle("CMSC 451 PROJ. 2: " + fileName);
  }

  public static void main(String[] args) {
    // write your code here
    new Main();
  }
}
